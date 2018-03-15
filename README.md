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
The team adopted a Scrum-based approach to developm a Working Prototype. At the beginniing our effort we addressed environments, scope development, and established Epics and multipe User Storie that were addressed in three successive Sprints.  We also agreed upon User-Centered design strategies that we could employ in a compressed timeframe.  

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



## Logical Architecture
The DAAS front end is easy to use, offering an optimal user experience.  For the UI we used JQuery, HTML5, and Bootstrap to provide a responsive, cross-platform design.  To aid user input, our web front end can dynamically retrieve values that are cached, persisted, or accessed via RESTful APIs.    RESTful APIs access common services implemented in JAVA and offer application processing logic that enable the user to view, add, or update content.  

Our DAAS solution architecture centralizes processing logic, isolating services within their own resource pool to guarantee sufficient memory and processing capacity.  This architecture will allow the service to be scaled horizontally across multiple servers as the load increases. 

Services persist changes to the database via Data Access Objects (DAOs).  Our team selected PostgreSQL as a robust, open-source database.  The persistence layer pools connections and offers efficient execution of database calls.  
Docker containers will be used to containerize software components. This operating system level virtualization will help in rapid deployment, easy portability of software components, better version control, component reuse, lightweight footprint, and low maintenance.

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/daas-arch-logical.png)

## Physical Architecture

The following diagram is a **reference model** for a robust production implementation – our MVP does not include clustered web, application, and database servers.  Nor have we implemented firewalls and load balancers.   DAAS does, however, reside on AWS infrastructure follwoing a traditional web-application architecture. 

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/daas-arch-physical.png)

## Code Flow

**Documentation must show code flow from client UI, to JavaScript library, to REST service to
database, pointing to code in the GitHub repository.**

When a user first connects to the website, the user is prompted to login via static html pages with bootstrap UI components and JavaScript, JQuery, and custom and custom JavaScript libraries.  The initial web page is the login.html from the Web project which has been skinned using the standard css, uses standard images, and is controlled by JavaScript. 

This generated JavaScript relies on open source tools such as bootstrap to present UI changes on a page, manage interactions with the API tier, and manage page-specific application data within the browser.
A successful log in, will result in navigation within the website. 

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/LogicalModel.png "DAAS Application Flow")


***
*******---------End of Technical Approach to Building DAAS---------*******
***




# Response to RFI Requirements

## Conformance to the US Digital Services Playbook
For each Play the team went through each item on the checklist and reviewed and answered key questions. We found that the questions were particularly helpful in establishing a context for product development and sparking ideas about Epics and User Stories.  We made use of the checklists although in some cases the project's short timeframe made them impracticable.  For example, we did not have sufficient time to use metrics to determine how well we met user needs (Play 1) or establish and manage to a budget (Play 5).  

Below, we outline how we addressed each Play in the Playbook We provide a brief narrative explaining how we addressed questions, and then a checkbox for each item in the checklist that we completed or at least considered. For brevity, we sometimes abbreviate or summarize checklist items. 

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

- [x] Give users clear information about where they are in each step of the process (User Story in backlog, not implemented)
- [x] Follow accessibility best practices to ensure all people can use the service
- [x] Provide users with a way to exit and return later to complete the process
- [x] Use language that is familiar to the user and easy to understand
- [x] Use language and design consistently throughout the service, including online and offline touch points

**Play 4 Build the service using agile and iterative practices**

The team adopted a Scrum-based approach to development and identified a high-level scope to build a Working Prototype in a short timeframe. We identified three Sprints: Sprint 0 wherein we addressed high-level planning, product scope, product backlog and high-level user stories, development tools, and the architecture. During this Sprint we also established our development environments.  In Sprint 1 we focused on User Stories that emphasized ease-of-use and on building a first Minimum Viable Product (MVP) furnishing basic DAAS functionality.  In the final Sprint, Sprint 2, we elaborated on DAAS to increase and enhance functionality and identified User Stories that would remain in the backlog as future enhancements. 

The team used Jira to manage project activities.  Given team members' busy schedules and the compressed project timeframe, we sometimes struggled to keep the Jira Sprint board up-to-date via daily Scrums. However, we did successfully manage scope using Jira and used it to track and fix defects. The development process was definitely iteritave with progressive deployments allowing team members to rapidly test and provide feedback on bugs. 

- [x] Ship a functioning “minimum viable product” (MVP) that solves a core user need as soon as possible
- [x] Run usability tests frequently to see how well the service works and identify improvements that should be made
- [x] Ensure the individuals building the service communicate closely using techniques such as launch meetings, war rooms, daily standups, and team chat tools  (The team met daily and used tools such as Slack to communicate.)
- [x] Keep delivery teams small and focused
- [x] Release features and improvements multiple times
- [x] Create a prioritized list of features and bugs, also known as the “feature backlog” and “bug backlog”
- [x] Use a source code version control system
- [x] Give the entire project team access to the issue tracker and version control system
- [x] Use code reviews to ensure quality


**Play 5 Structure budgets and contracts to support delivery**

For this effort the team did not establish contracts or craft a budget.  We were mindful of internal costs of this effort, but saw it as a long-term investment in our firm and opportunities to serve California in doing what we do best.  

**Play 6 Assign one leader and hold that person accountable**

Suresh Kannan, our CEO, served as the Product Manager.  He has decision-making authority regarding the approach and scope taken for the DAAS solution. Our team worked collaboratively and looked to Mr. Kannan to ensure that the MVP met all requirements and exhibits all the features outlined within the RFI and conforms to industry standards for knowledge sharing platforms.   

- [x] A product owner has been identified
- [x] All stakeholders agree that the product owner has the authority to assign tasks and make decisions about features and technical implementation details
- [x] The product owner has a product management background with technical experience 
- [x] The product owner has a work plan that includes budget estimates and identifies funding sources


**Play 7 Bring in experienced teams**

QualApps assembled a multidisciplanry team of experts, senior leaders in software development and delivery.  All but one of these individuals has a minimum of ten years experience; some have as much two decades of experience.  Our expertise spans numerous proprietary and open source technologies, products, and frameworks.  We have custom developed many applications and served as trusted advisors to our clients.  A sampling of our accomplishments is as follows:

* For the California Public Employees' Retirement System (CalPERS), we architected and developed a robust enterprise application integration framework built in Java to integrate subsystems with the CalPERS system of record. 
* For the California Department of Tax and Fee Amdministreation (formerly the Board of Equalization), QualApps developed and deployed a scalable and secure B2B integration solution. 
* For the Department of Justice, QualApps experts evaluated an existing Ruby on Rails criminal justice application and redesigned and replaced it with responsive solution that improves supportability and efficiency. 
* For CalPERS, QualApps custom developed The Travel Request and Expense Claims (TREK) application that enables State employees to establish travel profiles, automates the approval process for travel requests, and simplifies submitting expense claims for reimbursement. The solution generates all State-required forms and uses digital signatures for approval.  It also interfaces with multiple third-party services.  


What sets QualApps apart is that it is led by technologists.  Applying technology to solve business problems is not merely a vocation, it is a passion.  Under "Requiement B", addressed below, we have included the project team members and a link to their LinkidIn profiles. 

- [x] Member(s) of the team have experience building popular, high-traffic digital services
- [x] Member(s) of the team have experience designing mobile and web applications
- [x] Member(s) of the team have experience using automated testing frameworks
- [x] Member(s) of the team have experience with modern development and operations (DevOps) techniques like continuous integration and continuous deployment
- [x] Member(s) of the team have experience securing digital services


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
<td><a href="https://www.linkedin.com/in/joe-puli-27ab776/">Joe Puli</a></td>
</tr>
<tr>
<td>Technical Architect/DevOps Engineer</td>
<td><a href="https://www.linkedin.com/in/john-gedeon-a65a582/">John Gedeon</a></td>
</tr>
<tr>
<td>Interaction Designer/User Researcher/Usability Tester</td>
<td><a href="https://www.linkedin.com/in/daniel-fok-5a82907a/">Daniel Fok</a></td>
</tr>
<tr>
<td>Front End Web Developer</td>
<td><a href="https://www.linkedin.com/in/john-gedeon-a65a582/">John Gedeon</a></td>
</tr>
<tr>
<td>Backend Web Developer</td>
<td><a href="https://www.linkedin.com/in/roberto-obando-0751562/">Roberto Obando</a></td>
</tr>
<tr>
<td>Writer/Content Designer/Content Strategist</td>
<td><a href="https://www.linkedin.com/in/steeneric/">Eric Steen</a></td>
</tr>
<tr>
<td>Business Analyst</td>
<td><a href="https://www.linkedin.com/in/daniel-fok-5a82907a/">Daniel Fok</a></td>
<tr>
<td>Delivery Manager</td>
<td><a href="https://www.linkedin.com/in/steeneric/">Eric Steen</a></td>
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
