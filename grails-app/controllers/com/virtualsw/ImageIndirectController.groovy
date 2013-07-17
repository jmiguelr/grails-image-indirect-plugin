package com.virtualsw

class ImageIndirectController {

    static final int READ_BUFFER_SIZE = 10240
    def imageIndirectService

    def index(String imageName, String category) {
        boolean imageExists = false ;
        File fileToSend = new File( imageIndirectService.fullPath( category ) , imageName )

        fileToSend = fileToSend.exists() ? fileToSend : new File( imageIndirectService.fullPath( category ) , imageIndirectService.lastResortImage() )

        if( fileToSend.exists() && fileToSend.isFile() ) {
            InputStream is = new BufferedInputStream(new FileInputStream( fileToSend ));
            String mimeType = URLConnection.guessContentTypeFromStream(is);

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
