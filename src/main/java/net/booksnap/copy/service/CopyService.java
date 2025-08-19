package net.booksnap.copy.service;

import net.booksnap.copy.Copy;
import net.booksnap.copy.api.dto.CreateCopyRequest;

public interface CopyService {
    Copy createCopy(CreateCopyRequest createCopyRequest);

    byte[] generateQRCodeImage(Long copyId);

    Copy findCopyEntityById(Long copyId);

    Object findCopyById(Long copyId, String fields);

    void deleteCopyById(Long copyId);
}
