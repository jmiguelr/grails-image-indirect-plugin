package com.virtualsw

class ImageIndirectTagLib {

    static namespace = "ii"

    def imageIndirectService

    def imageTag = { attrs ->
        def imagename = attrs.'indirect-imagename'
        def category = attrs.'indirect-category'

        def name = attrs.name

        /* Standard img tag attributes */
        def id = attrs.id
        def alt = attrs.alt
        def title = attrs.title
        def lang = attrs.lang
        def style = attrs.style
        def width = attrs.width
        def height = attrs.height
        def ismap = attrs.ismap
        def longdesc = attrs.longdesc
        def usemap = attrs.usemap

        /* Standard img tag event attributes */
        def onclick = attrs.onclick
        def ondblclick = attrs.ondblclick
        def onmousedown = attrs.onmousedown
        def onmoouseup = attrs.onmoouseup
        def onmouseover = attrs.onmouseover
        def onmousemove = attrs.onmousemove
        def onmouseout = attrs.onmouseout
        def onkeypress = attrs.onkeypress
        def onkeydown = attrs.onkeydown
        def onkeyup = attrs.onkeyup

        //           File indir = new File(pageScope.location)
        //           indir.mkdir()
        //           File file = new File(indir.getPath() + File.separator + name + "." + type)
        //           file.toURL()
        //
        //           if (!file.exists()) {
        //               file.createNewFile()
        //               use (FileBinaryCategory)
        //               {
        //                   file << src.toURL()
        //               }
        //           }


        // <img class="Photo" src="${createLink(controller:'photo', action:'viewImage', id:'profileInstance.photos.get(1).id')}" />

        //  def parameters = "src=\"" + request.getContextPath() + "/imageIndirect?imageName=${imagename}"


        //
        // String link = grailsLinkGenerator.link(controller: 'imageIndirect' , params: [imageName: imagename, category:category] )
        String link =  imageIndirectService.imageLink( imagename , category )
        String imgAttrs = ""

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
