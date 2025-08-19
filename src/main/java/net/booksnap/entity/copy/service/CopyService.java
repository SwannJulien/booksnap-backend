package net.booksnap.entity.copy.service;

import net.booksnap.entity.copy.Copy;
import net.booksnap.entity.copy.api.dto.CreateCopyRequest;

public interface CopyService {
    Copy createCopy(CreateCopyRequest createCopyRequest);

    byte[] generateQRCodeImage(Long copyId);

    Copy findCopyEntityById(Long copyId);

    Object findCopyById(Long copyId, String fields);

    void deleteCopyById(Long copyId);
}
