package com.example.demo.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.QuestionAnswerService;
import com.example.demo.Service.UserCrackService;
//import com.example.demo.model.Language;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")
public class QuestionAnswerRestController {

    private AuthenticationManager authenticationManager;

    @Autowired
    private FileStorageService fileStorageService;




    @Autowired
    private QuestionAnswerService nativeQueryService;
    //@PostMapping(value = "/uploadFiles/{id}")
    //public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@PathVariable(value = "id") Long id) {
    /*
     * public UploadFileResponse uploadFiles( MultipartFile file,Long id) { DBFile
     * dbFile = dbFileStorageService.storeFile(file,id);
     *
     * String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
     * .path("/downloadFile/") .path(dbFile.getId()) .toUriString();
     *
     * return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
     * file.getContentType(), file.getSize()); }
     */

/*
    @PostMapping("/uploadFile/{id}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@PathVariable(value = "id") Long id) {
        //DBFile dbFile = dbFileStorageService.storeFile(file,id);
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
*/

    /*
    @PostMapping("/uploadMultipleFiles/{id}")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,@PathVariable(value = "id") Long id) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file,id))
                .collect(Collectors.toList());
    }

    */

/*

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            // logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



*/


/*

@PostMapping(value = "/native")
public void questions(@RequestBody String  query)
{
     nativeQueryService.executeNativeQuery(query);
}




    @Inject
    private TokenEndpoint tokenEndpoint;

    @RequestMapping(value="/generate-token", method = RequestMethod.POST,  consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<?> getToken(Principal principal, @RequestParam Map<String, String> name ,  @RequestHeader HttpHeaders httpHeaders) throws HttpRequestMethodNotSupportedException {

        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", "appid");
        parameters.put("client_secret", "myOAuthSecret");
        parameters.put("grant_type", "password");
        parameters.put("password", "jwtpass");
        parameters.put("scope", "read write");
        parameters.put("username","john.doe");

        return tokenEndpoint.getAccessToken(principal, parameters);
    }






*/

}







