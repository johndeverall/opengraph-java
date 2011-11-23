OpenGraph for Java is a small class used to represent the Open Graph protocol (available from http://opengraphprotocol.org/)

This project is entirely open source due to the size of the code, so please go nuts and do whatever you want with the code.

Due to the lack of useful native DOM parsers this class implements the HTMLCleaner library (available at http://htmlcleaner.sourceforge.net/index.php), please find the license for it at the bottom of this readme. There is the hope to remove reliance on third party libraries at a later stage.
## Usage ##
In this example we will fetch the og:title and og:type contents, while ignoring any errors if this page does not comply with the Open Graph protocol standard (set in the constructor via true)

> OpenGraph testPage = new OpenGraph("http://uk.rottentomatoes.com/m/1217700-kick_ass", true);

> String title = testPage.getContent("title");

> String type = testPage.getContent("type");

Another example (available in the examples/ folder) demonstrates the support for custom OpenGraph namespaces

	OpenGraph movie = new OpenGraph("http://www.rottentomatoes.com/m/back_to_the_future/", true);
	System.out.println("Movie: " + movie.getContent("title"));
	for (MetaElement director : movie.getProperties("director"))
	{
		OpenGraph extendedInfo = director.getExtendedData();
		System.out.println("Directed by: " + extendedInfo.getContent("title"));
	}

	for (MetaElement member : movie.getProperties("cast"))
	{
		OpenGraph extendedInfo = member.getExtendedData();
		System.out.println("Starring: " + extendedInfo.getContent("title"));
	}

## Features ##
* Is capable of handling the charset provided by the page when reading in the contents (thanks to [rkhmelyuk](https://github.com/rkhmelyuk))
* Support's the ability for social applications to declare their own namespaces and OpenGraph meta
* Hashtable like representation of an Open Graph page
* Output to HTML (render the meta data back out as <meta> tags)
* Create OG data from scratch (the ability to use this class as a reverse and generate OG meta tags)

## License ##
HTMLCleaner license (taken from http://htmlcleaner.sourceforge.net/license.php)

    Copyright (c) 2006-2007, HtmlCleaner team.
    All rights reserved.
    
    Redistribution and use of this software in source and binary forms, 
    with or without modification, are permitted provided that the 
    following conditions are met:
    
    * Redistributions of source code must retain the above
      copyright notice, this list of conditions and the
      following disclaimer.
    
    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the
      following disclaimer in the documentation and/or other
      materials provided with the distribution.
    
    * The name of HtmlCleaner may not be used to endorse or promote
      products derived from this software without specific prior
      written permission.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
    "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
    LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR 
    A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
    OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
    SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
    LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY 
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
    OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
