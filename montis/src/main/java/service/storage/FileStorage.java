package service.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {

	String persistFile(MultipartFile file);
}
