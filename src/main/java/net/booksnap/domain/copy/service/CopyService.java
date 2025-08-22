package net.booksnap.domain.copy.service;

import net.booksnap.domain.copy.Copy;
import net.booksnap.domain.copy.api.dto.CreateCopyRequest;

public interface CopyService {
    Copy createCopy(CreateCopyRequest createCopyRequest);

    byte[] generateQRCodeImage(Long copyId);

    Copy findCopyEntityById(Long copyId);

    Object findCopyById(Long copyId, String fields);

    void deleteCopyById(Long copyId);
}
