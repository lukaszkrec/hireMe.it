package it.hrme.business;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class FileService {

    public String encodeFile(byte[] file) {
        byte[] encode = Base64.getEncoder().encode(file);
        return new String(encode, StandardCharsets.UTF_8);
    }
}
