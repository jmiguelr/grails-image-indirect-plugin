grails-image-indirect-plugin
============================

Summary:

A Grails plugin to access images anywhere and make it looks as local


Status:

In early development stage. 

Wanna help?. Contact me via github or twitter @jmiguel


More (short) info:

This grails plugin adds a new tag  <ii:imageTag /> which will allow your application serve images on your filesystem which are outside your application context. I know. You could do it with some Apache (or other webServer)
 tricks, but sometimes this approach can be very convenient. 

** Use by example **

Simplest use:

1 - Add this variable on your Config.groovy

imageindirect.basePath='/tmp/images'

2 - Deploy a photo (say, myPhoto.jpg) on that folder
3 - Write anywhere on you GSP: <ii:imageTag indirect-imagename="myPhoto.jpg"/> 
4 - You got it!


A bit more advanced use:

You can define categories of photos and make them accessible both on relative or absolute paths. Example:

1 - Add on your Config.groovy

imageindirect.basePath='/tmp/images'
imageindirect.category.landscapes='/tmp/landscapePhotos'
imageindirect.category.macro='macroPhotos/'

2 - Put on /tmp/images any photo. Say: "myAvatar.gif"
    Put on /tmp/landscapePhotos , "majorca.png" 
    Put on /tmp/images/macroPhotos , for example, "antFace.jpg" 

3 - And on you GSP: 
	<ii:imageTag indirect-imagename="myAvatar.gif"/><br>
	<ii:imageTag indirect-category="landscapes" indirect-imagename="majorca.png"/><br>
	<ii:imageTag indirect-category="macroPhotos" indirect-imagename="antFace.jpg"/><br>

4 - That's it!. 
 


