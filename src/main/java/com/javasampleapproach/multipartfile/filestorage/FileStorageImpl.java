package com.javasampleapproach.multipartfile.filestorage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageImpl implements FileStorage{
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("filestorage");
 
	@Override
	public void store(MultipartFile file){
		try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	
	@Override
    public Resource loadFile(String filename) {
        try {
//            File file = new File("application_1533545434698_0110%25153441328121");

            Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation) && path.getFileName().toString().contains("application_1533545434698_0110"))
                    .forEach(x -> {
                        deleteFile(x.toAbsolutePath().toString());
                    });

            File file1 = new File(rootLocation.toString(), "application_1533545434698_0110%1231231321223");

            file1.createNewFile();


//            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file1.toURI());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("Error! -> message = " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
	@Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void deleteFile(String filename) {
        File file = rootLocation.resolve(filename).toFile();
        if(file.exists()){
            file.delete();
        }
    }

	@Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

	@Override
	public Stream<Path> loadFiles() {
        try {
            return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
        	throw new RuntimeException("\"Failed to read stored file");
        }
	}
}