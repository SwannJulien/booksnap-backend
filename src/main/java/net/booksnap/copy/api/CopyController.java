package net.booksnap.copy.api;

import jakarta.validation.Valid;
import net.booksnap.copy.api.dto.CreateCopyRequest;
import net.booksnap.copy.service.CopyService;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/copies")
public class CopyController {

    private final CopyService copyService;

    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCopy(@RequestBody @Valid CreateCopyRequest createCopyRequest) {
         copyService.createCopy(createCopyRequest);
    }

    @GetMapping("/{copyId}")
    public Object getCopy(@PathVariable Long copyId, 
                         @RequestParam(required = false) String fields) {
        return copyService.findCopyById(copyId, fields);
    }

    @GetMapping("/{copyId}/qrcode")
    public ResponseEntity<byte[]> getCopyQRCode(@PathVariable Long copyId) {
        byte[] qrCodeImage = copyService.generateQRCodeImage(copyId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentDisposition(ContentDisposition.inline()
            .filename("copy-" + copyId + "-qr.png").build());

        return ResponseEntity.ok()
            .headers(headers)
            .body(qrCodeImage);
    }
}