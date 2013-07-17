package com.virtualsw

import org.springframework.web.multipart.MultipartFile

class ImageIndirectService {

    def grailsApplication

    String fullPath(String category = null) {

        String returnPath = grailsApplication.config.imageindirect.basePath
        String categoryUrl = category ? grailsApplication.config.imageindirect.category."${category}" : null

        if (categoryUrl) {
            if (categoryUrl.startsWith("/")) {
                returnPath = categoryUrl
            } else {
                returnPath += "/${categoryUrl}"
            }
        }
        return returnPath
    }

    File storeImage(MultipartFile multipartFile, String desiredName = null, String category = null) {
        if (multipartFile) {
            def storagePath = fullPath(category)
            def physicalFileName = desiredName ?: multipartFile.originalFilename
            File file = new File(storagePath, physicalFileName)
            multipartFile.transferTo(file)
            return file
        }
    }

    String lastResortImage() {
        grailsApplication.config.imageindirect.nophoto
    }

}
