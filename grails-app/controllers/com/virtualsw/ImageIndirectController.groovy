package com.virtualsw

class ImageIndirectController {

    static final int READ_BUFFER_SIZE = 1024
    def imageIndirectService

    def index(String imageName, String category) {
        File fileToSend = new File( imageIndirectService.fullPath( category ) , imageName )

        println("ImageIndirect - params: ${params} We'll try to get image [${fileToSend.absolutePath}]" )

        if( fileToSend.exists() ) {
            InputStream is = new BufferedInputStream(new FileInputStream( fileToSend ));
            String mimeType = URLConnection.guessContentTypeFromStream(is);
            println("ImageIndirect - mime type for [${fileToSend.name}]: ${mimeType}")
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
