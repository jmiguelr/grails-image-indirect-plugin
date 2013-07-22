grails-image-indirect-plugin
============================

<h3>Summary</h3>

A Grails plugin to access images anywhere and make it looks as local


<h3>Status</h3>

In early development stage. 

Wanna help?. Contact me via github or twitter <a href="http://twitter.com/jmiguel">@jmiguel</a>

<hr>

<h3>More (short) info:</h3>

This grails plugin adds a new tag  &lt;ii:imageTag /&gt; which will allow your application serve images on your filesystem which are outside your application context. I know. You could do it with some Apache (or other webServer)
 tricks, but sometimes this approach can be very convenient. 

<h2>Use by example</h2>

<h4>Simplest use:</h4>

<ul>
	<li>Add this variable on your Config.groovy

<p>imageindirect.basePath='/tmp/images'</p>

	<li>Deploy a photo (say, myPhoto.jpg) on that folder
	<li>Write anywhere on you GSP: &lt;ii:imageTag indirect-imagename="myPhoto.jpg"/&gt; 
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
 
 
From v 0.0.5 you can also define a 'last resort' default file just in case the requested one doesn't exist. THis can be
very useful when you need things like a default icon, default user avatar image...


 
