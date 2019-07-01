# xPression-PDPX-Image-Reference-Checker
Searches OpenText xPression PDPX files for invalid image references which would prevent import into a target environment.


## Original README

PDPImageRefScanner

Created by: Brooks Hagenow<br/>
Created on: June 7, 2011

### Built using Java 1.6.0_25 but should be able to execute on Java 1.5
===================================================================

This utility scans a PDP file for invalid image references. If you
find that a customer's PDP can not be imported because of image
references that can not be found, this utility may be used to
identify all invalid image references saving you from going back
and forth with the customer fixing each invalid reference
individually through an iterative process.

This utility creates a report listing content items which contain
invalid image references and then lists those references. If the
content items has multiple image references but only one is invalid
only the invalid image reference will be listed.


You should be able to run this utility by double clicking on the
PDPImageRefScanner.jar file. If that does not work try running it
from the command line using the following command.

java -jar PDPImageRefScanner.jar



### SAMPLE OUTPUT FOR A VALID PDP:
------------------------------

> Content items without image references: 1833<br/>
> Content items with image references: 28<br/>
> Content items with bad image references: 0<br/>
> Total bad image references: 0





### SAMPLE OUTPUT FOR PDP WITH INVALID IMAGE REFERENCES:
----------------------------------------------------

> Content items without image references: 1633<br/>
> Content items with image references: 28<br/>
> Content items with bad image references: 3<br/>
> Total bad image references: 10
> 
> The following bad image references were found:
> 
> Content ID: 31024<br/>
> Content Name: First Page New Contact Information Footer<br/>
> Content Language: English<br/>
> Last Modified: 2011-05-13 17:22:41.0<br/>
> Author: xDesignUser<br/>
> &nbsp;&nbsp;Image refID: 6063  Image Name: CustomBullet<br/>
> &nbsp;&nbsp;Image refID: 6064  Image Name: CustomBullet<br/>
> &nbsp;&nbsp;Image refID: 6066  Image Name: CustomBullet<br/>
> &nbsp;&nbsp;Image refID: 6067  Image Name: CustomBullet
> 
> Content ID: 31021<br/>
> Content Name: First Page Payment End Stub<br/>
> Content Language: English<br/>
> Last Modified: 2011-04-29 12:00:13.0<br/>
> Author: xDesignUser<br/>
> &nbsp;&nbsp;Image refID: 6839  Image Name: CompanyLogo
> 
> Content ID: 52154<br/>
> Content Name: Contact Information Footer<br/>
> Content Language: English<br/>
> Last Modified: 2011-05-03 21:57:40.0<br/>
> Author: xDesignUser<br/>
> &nbsp;&nbsp;Image refID: 5864  Image Name: CustomBullet<br/>
> &nbsp;&nbsp;Image refID: 5861  Image Name: CustomBullet_1<br/>
> &nbsp;&nbsp;Image refID: 5862  Image Name: CustomBullet_1<br/>
> &nbsp;&nbsp;Image refID: 5863  Image Name: CustomBullet_1<br/>
> &nbsp;&nbsp;Image refID: 5865  Image Name: CustomBullet_1


### SAMPLE OUTPUT FOR AN INVALID PDP:
---------------------------------

> Unable to process file: C:\Temp\39795356_PDP_20110531.zip
> 
> invalid CEN header (bad compression method)
