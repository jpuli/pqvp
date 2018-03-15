# California Department of Technology 
# Request for Information (RFI) # CDT–PQVP–0118 
# Pre-Qualified Vendor Pool for Agile Development – Digital Services

http://daas.qualapps.com/

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/QualApps%2C%20Inc.png)

## QualApps’ ADPQ Submission
QualApps is thankful for the opportunity to submit a rsponse to RFI# CDT–PQVP–0118.  In a short timeframe, QualApps mobilized a multi-disciplinary team to review this RFI and rapidly respond. We are pleased with the outcome and hope that the Department of Technollogy is equally pleased with our Working Prototype and Technical Approach.  


## [Link to DAAS  Web Application ](http://daas.qualapps.com/)

This application is fully responsive and complies with ADA guidelines.  It is best viewed in Chrome or FireFox, but will function in Edge or IE. We created three users, each with a different role: Janepublic (Viewer), Johnappleseed (Approver), and SaraJaneSmith (Creator).  To review this web-application and evaluate the functionlity, use the following credentials: 

**Username: Johnappleseed**
  
**Password: Appleseed**

## Managing Product Development
Link to JIRA: https://qualappsinc.atlassian.net/secure/RapidBoard.jspa?rapidView=1

Read only Username and Password

# Technical Approach to Building DAAS
The team adopted a Scrum-based approach to development and identified a high-level scope to build a Working Prototype in a short timeframe. We identified three Sprints: Sprint 0 wherein we addressed high-level planning, product scope, product backlog and high-level user stories, development tools, and the architecture. In During this Sprint we also established our development environments.  In Sprint 1 we focused on User Stories that emphasized eas-of-use and on building a first Minimum Viable Product (MVP) furnished basic DAAS functionality.  In the final Sprint, Sprint 2, we elaborated on DAAS to increase and enhance functionality and identified User Stories that would remain in the backlog.   

User-centered design

Our team chose modern tools and techniques to manage this effort and to build the DAAS solution. The team used a "default to open" approach, leveraging many of the tools our company is familiar with thus accelerating delivery time. We used the following tools which we've catagorized as 
1) "Design-Time", meaning that we employed them for management and design activities, and 

2) "Run-Time" which means that these products comprise the DAAS execution platform.

**Design-Time**

* Jira -- managing Sprints and their activities: Epics and User Stories

* Jenkins -- build and deploy

* Dropbox -- sharing files 

* Slack -- communication

* Oracle data modeler -- develop logical and physical data models

* Github -- source control

* Visio -- documentation

* InDesign -- UI design


**Run-Time**

* JQuery -- UI

* HTML5 -- UI

* Bootstrap framework -- UI

* Swagger/OpenAPI -- Application

* Java -- Application

* Spring Boot -- Application

* AWS -- Infrastructure

* Linux/Docker -- Platform 

* NGINX -- Web Server

* Spring Boot -- Application Server

* Postgress -- Database 

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/LogicalModel.png "DAAS Logical")


## Logical Architecture

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/daas-arch-logical.png)

## Physical Architecture

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/daas-arch-physical.png)

## Code Flow

Documentation must show code flow from client UI, to JavaScript library, to REST service to
database, pointing to code in the GitHub repository. 

***
*******End of Technical Approach to Building DAAS*******
***




# Response to RFI Requirements

## Conformance to the US Digital Services Playbook
At the beginning of the project, for each Play the team went through each item on the checklist and reviewed and answered key questions. We found that the questions were particularly helpful in establishing a context for product development and sparking ideas about Epics and User Stories.  We made use of the checklists although in some cases the project's short timeframe made them impracticable.  For example, we did not have sufficient time to use metrics to determine how well we met user needs (Play 1) or establish and manage to a budget (Play 5).  

Below, we outline how we addressed each Play in the Playbook We provide a brief narrative explaining how we addressed questions, and then a checkbox for each item in the checklist that we completed. For brevity, we sometimes abbreviate or summarize checklist items. 

**Play 1 Understand what people need**

Regarding Key Questions: We considered (based on the RFI) that the primary users are State departments and agencies.  We thought about various applications for a knowledge sharing platform.  For example, we considered tailoring it to assist with workforce development, in particular providing a platform wherein seasoned employees and millennials could collaborate on knowledge transfer.  Another consideration was developing a knowledge-sharing platform for trouble-shooting technical issues.  In the end, we decided we could develop a feature-rich platform that would support any subject area, which could be tagged by topics. Questions helped us establish our initial backlog, e.g., "As a user I want to be able to search knowledge based on key-words/topics".  

- [x] Early in the project, spend time with current and prospective users of the service
- [x] Use a range of qualitative and quantitative research methods (This was done minimally; see survey.)
- [x] Test prototypes of solutions with real people
- [x] As the digital service is being built, regularly test it

**Play 2 Address the whole experience, from start to finish**

The team discussed the key questions for Play 2 and identified a number of common issues with knowledge-sharing platforms.  Chief among these concerns was the ability to quickly identify information pertinent to a user.  This discussion led to user stories supporting knowledge organization and effective use of labels. Other items discussed were mechanisms to notify users via multiple channels when a discussion thread they subscribed to was updated.  

We discussed a couple of metrics for ways to evaluate the effectiveness of the DAAS solution: after interacting with the solution, users would be asked to rank satisfaction with a handful of features (e.g., ability to add knowledge, modify existing knowledge artifact, comment on an artifact, find answers to questions).  Users would assign up to five stars to rank satisfaction level. In talking to stakeholders, we determined that this option should be used sparingly to avoid undermining the user experience.   

- [x] Understand the different points at which people will interact with the service – both online and in person
- [x] Identify pain points in the current way users interact with [similar] service[s]
- [x] Develop metrics that will measure how well the service is meeting user needs at each step of the service

**Play 3 Make it simple and intuitive**

The team focused on developing a tool that provides an easy-to-understand flow of operations based on what users want to accomplish: search the knowledge database, search information based on categories, create knowledge content, bookmark relavant information, and contribute to existing content.  We focused on ease-of-navigation and acknowledged that furnishing multi-language capabilities would remain in the backlog given the timeframe of the project.

- [x] Use a simple and flexible design style guide for the service. Use the U.S. Web Design Standards as a default
- [x] Use the design style guide consistently for related digital services
- [x] Give users clear information about where they are in each step of the process
- [x] Follow accessibility best practices to ensure all people can use the service
- [x] Provide users with a way to exit and return later to complete the process
- [x] Use language that is familiar to the user and easy to understand
- [x] Use language and design consistently throughout the service, including online and offline touch points

**Play 4 Build the service using agile and iterative practices**

**Play 5 Structure budgets and contracts to support delivery**

**Play 6 Assign one leader and hold that person accountable**

**Play 7 Bring in experienced teams**

**Play 8 Choose a modern technology stack**

**Play 9 Deploy in a flexible hosting environment**

**Play 10 Automate testing and deployments**

**Play 11 Manage security and privacy through reusable processes**

**Play 12 Use data to drive decisions**

**Play 13 Default to open**


## RFI Requirements 
The README.md file should also make reference to the following:

**Requirement A: Assigned one (1) leader and gave that person authority and responsibility and held that person accountable for the quality of the prototype submitted;**

**Requirement B: Assembled a multidisciplinary and collaborative team that includes, at a minimum, five (5) of the labor categories as identified in Attachment B: PQVP AD-DS Labor Category Descriptions;**

QualApps convened a multidisciplinary team of highly experienced Information Technology (IT) professionals from within our internal staffing network to develop the DAAS knowledg-sharing solution. 

<table>
<thead>
<tr>
<th>Role (Labor Category)</th>
<th>Team Member</th>
</tr>
</thead>
<tbody>
<tr>
<td>Product Manager</td>
<td>Suresh Kannan</td>
</tr>
<tr>
<td>Agile Coach/Technical Architect</td>
<td>Joe Puli</td>
</tr>
<tr>
<td>Technical Architect/DevOps Engineer</td>
<td>John Gedeon</td>
</tr>
<tr>
<td>Interaction Designer/User Researcher/Usability Tester</td>
<td>Daniel Fok</td>
</tr>
<tr>
<td>Front End Web Developer</td>
<td>John Gedeon</td>
</tr>
<tr>
<td>Backend Web Developer</td>
<td>Roberto Obando</td>
</tr>
<tr>
<td>Writer/Content Designer/Content Strategist</td>
<td>Eric Steen</td>
</tr>
<tr>
<td>Business Analyst</td>
<td>Daniel Fok</td>
<tr>
<td>Delivery Manager</td>
<td>Eric Steen</td>
</tr>
<tr>
</tr></tbody></table> 

**Requirement C: Understood what people needed, by including people in the prototype development and design process;** 
The QualApps Project Director and Agile Coach reviewed the working prototype statement from the RFI to better understand and deconstruct the requirements of the prototype into epics. The QualApps Project Director coalesced a team of technical professionals to discuss how the identified epics would be architected based on the RFI requirements for simplicity, ease of use and open source.

The QualApps Project Director added additional analyst resources to the Scrum team to work with Izzie in establishing end user stories defining emergency and non-emergency notification needs.

The QualApps Researcher and Business analyst conducted internet-based research on the concepts for establishing an emergency notification network looking at the business needs of the individuals requesting notification as well as the technologies supporting such systems. Additional questions resulted from this research were posed to the end user to refine user stories and establish acceptance criteria.

vi.	A project was created in Jira  and the epics and user stories were added.
vii.	The QualApps team reviewed and prioritized user stories and determined the design of the prototype using agreed upon technologies.
viii.	Using the minimal viable product (MVP) approach, the Product Manager identified user stories belonging in backlog and assigned work to the team based on the most critical elements needed to provide a working prototype.
ix.	Once the prototype was tangible enough to produce a response, the team, including the end user, implemented role play. This included testing within our team in order to gain realistic and effective feedback for improvements.
x.	After receiving prototype feedback based on the role play, the team began integrating the feedback into the backlog as part of the next iteration of the prototype. Some of the identified user stories were created as icebox items to demonstrate that we are taking a MVP approach.

**Requirement D: Used at least a minimum of three (3) “user-centric design” techniques and/or tools**

**Requirement E: Used GitHub to document code commits**

**Requirement F: Used Swagger to document the RESTful API, and provided a link to the Swagger API**

**Requirement G: Complied with Section 508 of the Americans with Disabilities Act and WCAG 2.0**

**Requirement H: Created or used a design style guide and/or a pattern library**

**Requirement I: Performed usability tests with people**

**Requirement J: Used an iterative approach, where feedback informed subsequent work or versions of the prototype**

**Requirement K: Created a prototype that works on multiple devices, and presents a responsive design** 

**Requirement L: Used at least five (5) modern and open-source technologies, regardless of architectural ayer (frontend, backend, etc.)**

**Requirement M: Deployed the prototype on an Infrastructure as a Service (IaaS) or Platform as Service (PaaS) provider, and indicated which provider they used**

**Requirement N: Developed automated unit tests for their code**

**Requirement O: Setup or used a continuous integration system to automate the running of tests and continuously deployed their code to their IaaS or PaaS provider**

**Requirement P: Setup or used configuration management**

**Requirement Q: Setup or used continuous monitoring**

**Requirement R: Deployed their software in an open source container, such as Docker (i.e., utilized operating-system-level virtualization)**

**Requirement S: Provided sufficient documentation to install and run their prototype on another machine**

**Requirement T: Prototype and underlying platforms used to create and run the prototype are openly licensed and free of charge**
