grails-image-indirect-plugin
============================

<h3>Summary</h3>

A Grails plugin to serve images on your program located anywhere on your filesystem, not only on the application context path


<hr>

<h3>More (short) info:</h3>

This grails plugin adds a new tag  &lt;ii:imageTag /&gt; which allows your application to serve images located anywhere on your filesystem  (outside your application context). I know. You could do it with some Apache (or other webServer) tricks, but sometimes this approach can be very convenient. 

<h2>Use by example</h2>

<h4>Simplest use:</h4>

<ul>
	<li>Add this variable on your Config.groovy

<p>imageindirect.basePath='/tmp/images'</p>

	<li>Deploy a photo (say, myPhoto.jpg) on that folder
	<li>Write anywhere on your GSP: &lt;ii:imageTag indirect-imagename="myPhoto.jpg"/&gt; 
	<li>You got it!
</ul>


<h4>A bit more advanced use:</h4>

You can define categories of photos and make them accessible both on relative or absolute paths. Example:

<ul>
<li>Add to your Config.groovy

<p>imageindirect.basePath='/tmp/images'</p>
<p>imageindirect.category.landscapes='/tmp/landscapePhotos'</p>
<p>imageindirect.category.macro='macroPhotos/'</p>

<li><p>Put on /tmp/images any photo. Say: "myAvatar.gif"</p>
    <p>Put on /tmp/landscapePhotos , "majorca.png"</p> 
    <p>Put on /tmp/images/macroPhotos , for example, "antFace.jpg" </p>

<li>Write on your GSP: 
	<p>&lt;ii:imageTag indirect-imagename="myAvatar.gif"/&gt;</p>
	<p>&lt;ii:imageTag indirect-category="landscapes" indirect-imagename="majorca.png"/&gt;</p>
	<p>&lt;ii:imageTag indirect-category="macroPhotos" indirect-imagename="antFace.jpg"/&gt;</p>

<li>That's it!. 
</ul>

From v 0.0.4 you can use the plugin to store the images uploaded on the correct disk location. Just call the storeImage method on ImageIndirectService:

File storeImage(MultipartFile multipartFile, String desiredName = null, String category = null)  
 
From v 0.0.5 you can also define a 'last resort' default file just in case the requested one doesn't exist. This can be
very useful when you need things like a default icon, default user avatar image or something like that
