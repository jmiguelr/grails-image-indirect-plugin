package com.virtualsw

class ImageIndirectController {

    static final int READ_BUFFER_SIZE = 1024

    def index(String imageName, String category, String contenttype) {

        String fullUrl = grailsApplication.config.imageindirect.basePath
        String categoryUrl = category ? grailsApplication.config.imageindirect.category."${category}" : null
        File fileToSend

//        println("0- params: ${params}")
//        println("1- fullUrl ${fullUrl} , categoryUrl ${categoryUrl}")

        if ( categoryUrl ) {
            if (categoryUrl.startsWith("/")) {
                fullUrl = categoryUrl
            } else {
                fullUrl += "/${categoryUrl}"
            }
        }


        fileToSend = new File( fullUrl , imageName )

//        println("2- fullUrl ${fullUrl} , file: ${fileToSend.absolutePath}")

        if( fileToSend.exists() ) {
            InputStream is = new BufferedInputStream(new FileInputStream(new File( fullUrl , imageName )));
            String mimeType = URLConnection.guessContentTypeFromStream(is);
            println("3- mime: ${mimeType}")
            // response.setContentType("application/jpg")
            response.setContentType(mimeType)
            OutputStream out = response.getOutputStream();

            byte[] buffer = new byte[READ_BUFFER_SIZE];
            int len = is.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = is.read(buffer);
            }
            out.close();
        } else {
            response.status = 404
        }
    }
}
