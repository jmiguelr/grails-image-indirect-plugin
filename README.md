grails-image-indirect-plugin
============================

<h3>Summary</h3>

A Grails plugin to access images anywhere and make it looks as local


<h3>Status</h3>

In early development stage. 

Wanna help?. Contact me via github or twitter <a href="http://twitter.com/jmiguel">@jmiguel</a>

<center><hr width=35% noshade></center>

<h3>More (short) info:</h3>

This grails plugin adds a new tag  &lt;ii:imageTag /&gt; which will allow your application serve images on your filesystem which are outside your application context. I know. You could do it with some Apache (or other webServer)
 tricks, but sometimes this approach can be very convenient. 

<h2>Use by example</h2>

<h4>Simplest use:</h4>

<ul>
	<li>1 - Add this variable on your Config.groovy

imageindirect.basePath='/tmp/images'

	<li>2 - Deploy a photo (say, myPhoto.jpg) on that folder
	<li>3 - Write anywhere on you GSP: &lt;ii:imageTag indirect-imagename="myPhoto.jpg"/&gt; 
	<li>4 - You got it!
</ul>


<h4>A bit more advanced use:</h4>

You can define categories of photos and make them accessible both on relative or absolute paths. Example:

<ul>
<li>1 - Add on your Config.groovy

imageindirect.basePath='/tmp/images'
imageindirect.category.landscapes='/tmp/landscapePhotos'
imageindirect.category.macro='macroPhotos/'

<li>2 - Put on /tmp/images any photo. Say: "myAvatar.gif"
    Put on /tmp/landscapePhotos , "majorca.png" 
    Put on /tmp/images/macroPhotos , for example, "antFace.jpg" 

<li>3 - And on you GSP: 
	&lt;ii:imageTag indirect-imagename="myAvatar.gif"/&gt;
	&lt;ii:imageTag indirect-category="landscapes" indirect-imagename="majorca.png"/&gt;
	&lt;ii:imageTag indirect-category="macroPhotos" indirect-imagename="antFace.jpg"/&gt;

<li>4 - That's it!. 
</ul>
 




