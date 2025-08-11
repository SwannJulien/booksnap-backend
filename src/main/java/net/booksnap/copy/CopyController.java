package net.booksnap.copy;

import jakarta.validation.Valid;
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
    public void createCopy(@RequestBody @Valid CopyDTO copyDTO) {
         copyService.createCopy(copyDTO);
    }

    @GetMapping("/{copyId}")
    public CopyDTO getCopy(@PathVariable Long copyId) {
        return copyService.findById(copyId);
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