package com.virtualsw

class ImageIndirectTagLib {

    static namespace = "ii"

    def imageTag = { attrs, body ->

        def category = attrs.remove('indirect-category')
        def imagename = attrs.remove('indirect-imagename')
        def contenttype = attrs.remove('indirect-contenttype')

        def name = attrs.remove('name')

        /* Standard img tag attributes */
        def id = attrs.remove('id')
        def alt = attrs.remove('alt')
        def title = attrs.remove('title')
        def lang = attrs.remove('lang')
        def style = attrs.remove('style')
        def width = attrs.remove('width')
        def height = attrs.remove('height')
        def ismap = attrs.remove('ismap')
        def longdesc = attrs.remove('longdesc')
        def usemap = attrs.remove('usemap')

        /* Standard img tag event attributes */
        def onclick = attrs.remove('onclick')
        def ondblclick = attrs.remove('ondblclick')
        def onmousedown = attrs.remove('onmousedown')
        def onmoouseup = attrs.remove('onmoouseup')
        def onmouseover = attrs.remove('onmouseover')
        def onmousemove = attrs.remove('onmousemove')
        def onmouseout = attrs.remove('onmouseout')
        def onkeypress = attrs.remove('onkeypress')
        def onkeydown = attrs.remove('onkeydown')
        def onkeyup = attrs.remove('onkeyup')

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

        def parameters = "src=\"" + request.getContextPath() + "/imageIndirect?imageName=${imagename}"
        parameters += category ? "&category=${category}" : ""
        parameters += contenttype ? "&contenttype=${contenttype}" : ""
        parameters += '" '

        parameters += name ? " name=\"" + name + "\"" : ""
        parameters += alt ? " alt=\"" + alt + "\"" : ""
        parameters += id ? " id=\"" + id + "\"" : ""
        parameters += title ? " title=\"" + title + "\"" : ""
        parameters += lang ? " lang=\"" + lang + "\"" : ""
        parameters += style ? " style=\"" + style + "\"" : ""
        parameters += width ? " width=\"" + width + "\"" : ""
        parameters += height ? " height=\"" + height + "\"" : ""
        parameters += ismap ? " ismap=\"" + ismap + "\"" : ""
        parameters += longdesc ? " longdesc=\"" + longdesc + "\"" : ""
        parameters += usemap ? " usemap=\"" + usemap + "\"" : ""

        parameters += onclick ? " onclick=\"" + onclick + "\"" : ""
        parameters += ondblclick ? " ondblclick=\"" + ondblclick + "\"" : ""
        parameters += onmousedown ? " onmousedown=\"" + onmousedown + "\"" : ""
        parameters += onmoouseup ? " onmoouseup=\"" + onmoouseup + "\"" : ""
        parameters += onmouseover ? " onmouseover=\"" + onmouseover + "\"" : ""
        parameters += onmousemove ? " onmousemove=\"" + onmousemove + "\"" : ""
        parameters += onmouseout ? " onmouseout=\"" + onmouseout + "\"" : ""
        parameters += onkeypress ? " onkeypress=\"" + onkeypress + "\"" : ""
        parameters += onkeydown ? " onkeydown=\"" + onkeydown + "\"" : ""
        parameters += onkeyup ? " onkeyup=\"" + onkeyup + "\"" : ""

        out << "<img " + parameters + " />"
    }



}
