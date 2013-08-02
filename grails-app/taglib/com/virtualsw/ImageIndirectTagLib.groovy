package com.virtualsw

class ImageIndirectTagLib {

    static namespace = "ii"
    def imageIndirectService

    def imageTag = { attrs, body ->
        def imagename = attrs.getProperty('indirect-imagename')
        def category = attrs.getProperty('indirect-category')

        def name = attrs.getProperty('name')

        /* Standard img tag attributes */
        def id = attrs.getProperty('id')
        def alt = attrs.getProperty('alt')
        def title = attrs.getProperty('title')
        def lang = attrs.getProperty('lang')
        def style = attrs.getProperty('style')
        def width = attrs.getProperty('width')
        def height = attrs.getProperty('height')
        def ismap = attrs.getProperty('ismap')
        def longdesc = attrs.getProperty('longdesc')
        def usemap = attrs.getProperty('usemap')

        /* Standard img tag event attributes */
        def onclick = attrs.getProperty('onclick')
        def ondblclick = attrs.getProperty('ondblclick')
        def onmousedown = attrs.getProperty('onmousedown')
        def onmoouseup = attrs.getProperty('onmoouseup')
        def onmouseover = attrs.getProperty('onmouseover')
        def onmousemove = attrs.getProperty('onmousemove')
        def onmouseout = attrs.getProperty('onmouseout')
        def onkeypress = attrs.getProperty('onkeypress')
        def onkeydown = attrs.getProperty('onkeydown')
        def onkeyup = attrs.getProperty('onkeyup')

        //           File indir = new File(pageScope.location)
        //           indir.mkdir()
        //           File file = new File(indir.getPath() + File.separator + name + "." + type)
        //           file.toURL()
        //
        //           if (!file.exists()) {
        //               file.createNewFile();
        //               use (FileBinaryCategory)
        //               {
        //                   file << src.toURL()
        //               }
        //           }


        // <img class="Photo" src="${createLink(controller:'photo', action:'viewImage', id:'profileInstance.photos.get(1).id')}" />

        //  def parameters = "src=\"" + request.getContextPath() + "/imageIndirect?imageName=${imagename}"


        //
        // def link = grailsLinkGenerator.link(controller: 'imageIndirect' , params: [imageName: imagename, category:category] )
        def link =  imageIndirectService.imageLink( imagename , category )
        def imgAttrs = ""

        imgAttrs += name ? " name=\"" + name + "\"" : ""
        imgAttrs += alt ? " alt=\"" + alt + "\"" : ""
        imgAttrs += id ? " id=\"" + id + "\"" : ""
        imgAttrs += title ? " title=\"" + title + "\"" : ""
        imgAttrs += lang ? " lang=\"" + lang + "\"" : ""
        imgAttrs += style ? " style=\"" + style + "\"" : ""
        imgAttrs += width ? " width=\"" + width + "\"" : ""
        imgAttrs += height ? " height=\"" + height + "\"" : ""
        imgAttrs += ismap ? " ismap=\"" + ismap + "\"" : ""
        imgAttrs += longdesc ? " longdesc=\"" + longdesc + "\"" : ""
        imgAttrs += usemap ? " usemap=\"" + usemap + "\"" : ""

        imgAttrs += onclick ? " onclick=\"" + onclick + "\"" : ""
        imgAttrs += ondblclick ? " ondblclick=\"" + ondblclick + "\"" : ""
        imgAttrs += onmousedown ? " onmousedown=\"" + onmousedown + "\"" : ""
        imgAttrs += onmoouseup ? " onmoouseup=\"" + onmoouseup + "\"" : ""
        imgAttrs += onmouseover ? " onmouseover=\"" + onmouseover + "\"" : ""
        imgAttrs += onmousemove ? " onmousemove=\"" + onmousemove + "\"" : ""
        imgAttrs += onmouseout ? " onmouseout=\"" + onmouseout + "\"" : ""
        imgAttrs += onkeypress ? " onkeypress=\"" + onkeypress + "\"" : ""
        imgAttrs += onkeydown ? " onkeydown=\"" + onkeydown + "\"" : ""
        imgAttrs += onkeyup ? " onkeyup=\"" + onkeyup + "\"" : ""

        out << "<img src='${link}' ${imgAttrs} />"
    }



}
