# California Department of Technology 
# Request for Information (RFI) # CDT–PQVP–0118 
# Pre-Qualified Vendor Pool for Agile Development – Digital Services

http://daas.qualapps.com/

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/QualApps%2C%20Inc.png)

## QualApps’ ADPQ Submission
QualApps is thankful for the opportunity to submit a response to RFI# CDT–PQVP–0118.  In a short timeframe, QualApps mobilized a multi-disciplinary team to review this RFI and rapidly respond. We are pleased with the outcome and hope that the Department of Technology is equally pleased with our Working Prototype and Technical Approach.  


## [Link to DAAS  Web Application ](http://daas.qualapps.com/)

This application is fully responsive and complies with guidelines.  It is best viewed in Chrome or FireFox, but will function in Edge or IE. We created three users, each with a different role: Jessica (Admin), Harvey (Creator), and Mike (Viewer).  To review this web-application and evaluate the functionality, use any of these personas.  

For instruction about how to use the DAAS knowledge sharing application, please see the 
<a href="https://github.com/jpuli/pqvp/wiki/User-Roles.md">DAAS User Roles and Instructions</a>.


## Managing Product Development
Link to <a href="https://qualappsinc.atlassian.net/secure/RapidBoard.jspa?rapidView=1">DAAS - JIRA Project</a>.

Read only Username and Password

Alternatively, you can view <a href="https://github.com/jpuli/pqvp/tree/master/jira%20screenshots">JIRA Screenshots</a> of our JIRA Project.

# Technical Approach to Building DAAS
The team adopted a <a href="https://github.com/jpuli/pqvp/blob/master/DAAS Agile Approach.png">Scrum-based approach</a> to develop a Working Prototype. At the beginning our effort we addressed environments, scope development, and established Epics and multiple User Stories that were addressed in three successive Sprints.  We also agreed upon User-Centered design strategies that we could employ in a compressed timeframe.  

Our team chose modern tools and techniques to manage this effort and to build the DAAS solution. The team used a "default to open" approach, leveraging many of the tools our company is familiar with thus accelerating delivery time. We used the following tools which we've categorized as 
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

* Adobe XD -- UI design


**Run-Time**

* JQuery -- UI

* HTML5 -- UI

* Bootstrap framework -- UI

* OpenAPI -- Application

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

The following diagram is a **reference model** for a robust production implementation – our MVP does not include clustered web, application, and database servers.  Nor have we implemented firewalls and load balancers.   DAAS does, however, reside on AWS infrastructure following a traditional web-application architecture. 

![QualApps, Inc.](https://github.com/jpuli/pqvp/blob/master/daas-arch-physical.png)

## Code Flow

The DAAS application is designed and developed using the traditional Model-View-Controller (MVC) architecture. The application consists of html pages representing the view layer and the controller layer to orchestrate the incoming HTTP requests. The service layer is used to apply business validations, query, and save data. The model layer consists of data access objects (DAOs) that interact with postgres SQL database. 

When a user first connects to the website, the user is prompted to login via responsive static HTML5 pages with Bootstrap UI components. All user login requests are routed to a loginController. A loginService layer object will authenticate the user and apply business validations.  Upon successful authentication, the loginController redirects the user to a homeController. A home page related to a service layer component will use the corresponding DAO layer to query the user specific home page information and forward the request to the home page HTML template. The application uses Thymeleaf HTML template engine to interpret outgoing HTML template responses, interpreting template tags to generate the user's home HTML page.  

The application is architected to operate and service HTTP user request in two modes.  

1) REST API mode: the application exposes REST API services via RESTControllers to service HTTP requests (PUT, GET, POST, DELETE) and sends back JSON response data.  The DAAS application will use the REST API to integrate seamlessly and securely with Third-Party applications.

2) MVC mode:  the application will service HTTP requests using RouteControllers that use the service layer components to service the request and forward requests to a template engine to serve static html pages.

The DAAS solution uses common service layer components in both modes to serve user requests and provide an optimal user experience.

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
- [x] Use a range of qualitative and quantitative research methods (This was done minimally; see <a href="https://github.com/jpuli/pqvp/blob/master/interview.md">survey</a> .)
- [x] Test prototypes of solutions with real people
- [x] As the digital service is being built, regularly test it

**Play 2 Address the whole experience, from start to finish**

The team discussed the key questions for Play 2 and identified a number of common issues with knowledge-sharing platforms.  Chief among these concerns was the ability to quickly identify information pertinent to a user.  This discussion led to user stories supporting knowledge organization and effective use of labels. Other items discussed were mechanisms to notify users via multiple channels when a discussion thread they subscribed to was updated.  

We discussed a couple of metrics for ways to evaluate the effectiveness of the DAAS solution: after interacting with the solution, users would be asked to rank satisfaction with a handful of features (e.g., ability to add knowledge, modify existing knowledge artifact, comment on an artifact, find answers to questions).  Users would assign up to five stars to rank satisfaction level. In talking to stakeholders, we determined that this option should be used sparingly to avoid undermining the user experience.   

- [x] Understand the different points at which people will interact with the service – both online and in person
- [x] Identify pain points in the current way users interact with [similar] service[s]
- [x] Develop metrics that will measure how well the service is meeting user needs at each step of the service

**Play 3 Make it simple and intuitive**

The team focused on developing a tool that provides an easy-to-understand flow of operations based on what users want to accomplish: search the knowledge database, search information based on categories, create knowledge content, bookmark relavent information, and contribute to existing content.  We focused on ease-of-navigation and acknowledged that furnishing multi-language capabilities would remain in the backlog given the timeframe of the project.

- [x] Give users clear information about where they are in each step of the process (User Story in backlog, not implemented)
- [x] Follow accessibility best practices to ensure all people can use the service
- [x] Provide users with a way to exit and return later to complete the process
- [x] Use language that is familiar to the user and easy to understand
- [x] Use language and design consistently throughout the service, including online and offline touch points

**Play 4 Build the service using agile and iterative practices**

The team adopted a Scrum-based approach to development and identified a high-level scope to build a Working Prototype in a short timeframe. We identified three Sprints: Sprint 0 wherein we addressed high-level planning, product scope, product backlog and high-level user stories, development tools, and the architecture. During this Sprint we also established our development environments and built wire-frames.  In Sprint 1 we focused on User Stories that emphasized ease-of-use and on building a first Minimum Viable Product (MVP) furnishing basic DAAS functionality.  In the final Sprint, Sprint 2, we elaborated on DAAS to increase and enhance functionality and identified User Stories that would remain in the backlog as future enhancements. 

The team used Jira to manage project activities.  Given team members' busy schedules and the compressed project timeframe, we sometimes struggled to keep the Jira Sprint board up-to-date via daily Scrums. However, we did successfully manage scope using Jira and used it to track and fix defects. The development process was definitely iterative with progressive deployments allowing team members to rapidly test and provide feedback on bugs. 

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

QualApps assembled a multidisciplinary team of experts, senior leaders in software development and delivery.  All but one of these individuals has a minimum of ten years experience; some have as much two decades of experience.  Our expertise spans numerous proprietary and open source technologies, products, and frameworks.  We have custom developed many applications and served as trusted advisors to our clients.  A sampling of our accomplishments is as follows:

* For the California Public Employees' Retirement System (CalPERS), we architected and developed a robust enterprise application integration framework built in Java to integrate subsystems with the CalPERS system of record. 
* For the California Department of Tax and Fee Administration (formerly the Board of Equalization), QualApps developed and deployed a scalable and secure B2B integration solution. 
* For the Department of Justice, QualApps experts evaluated an existing Ruby on Rails criminal justice application and redesigned and replaced it with responsive solution that improves supportability and efficiency. 
* For CalPERS, QualApps custom developed The Travel Request and Expense Claims (TREK) application that enables State employees to establish travel profiles, automates the approval process for travel requests, and simplifies submitting expense claims for reimbursement. The solution generates all State-required forms and uses digital signatures for approval.  It also interfaces with multiple third-party services.  


What sets QualApps apart is that it is led by technologists.  Applying technology to solve business problems is not merely a vocation, it is a passion.  Under "Requirement B", addressed below, we have included the project team members and a link to their LinkedIn profiles. 

- [x] Member(s) of the team have experience building popular, high-traffic digital services
- [x] Member(s) of the team have experience designing mobile and web applications
- [x] Member(s) of the team have experience using automated testing frameworks
- [x] Member(s) of the team have experience with modern development and operations (DevOps) techniques like continuous integration and continuous deployment
- [x] Member(s) of the team have experience securing digital services


**Play 8 Choose a modern technology stack**

The development team selected a product stack that it was familiar with to aid a quick delivery time.  We selected state-of-the-art open source technologies that are commonly in use and, we believe, sustainable.  These products made it easy to comply with the RFI's technical requirements.  As outlined in the Technical Response, the team used the following tools for DAAS solution:

**Run-Time**

* JQuery -- We choose JQuery for its flexible framework and robust feature set for UI components, such as binding data to elements. 

* HTML5 -- HTML5 is the latest standard for web UIs, providing features that are used extensively within this application.

* Bootstrap framework -- Bootstrap was chosen for its ability to build responsive UI components and features that can be easily manipulated for the project's needs. 

* OpenAPI -- The RFI requires the use of OpenAPI. We used this tool to document APIs.  

* Java -- We selected Java because it is a robust language that performs well and runs on any platform.  Our team members are expert Java programmers with many years of experience with this language. 

* AWS -- This platform made the most sense given the rest of the product stack and RFI requiremnts. 

* Linux/Docker -- QualApps selected Docker because of its containerization ability to rapidly stand up computing environments.  The use of images to package, deploy, and run apps helps us meet RFI requirements, namely providing instructions that enables others to deploy DAAS.  

* NGINX -- The team selected the open-source NGINX because it is lightweight and very easily meets performance demands.  

* Spring Boot -- Our team is very familiar with the Spring Boot framework.  The framework simplifies configuration and enabled us tp quickly stand up web applications.  

* Postgres -- We selected Postgres because of its power and flexibility, its market sustainability, its broad customer base, its applicability across industries, e.g., finance, gaming, government, and our experience with it.  


- [x] Choose software frameworks that are commonly used by private-sector companies creating similar services
- [x] Whenever possible, ensure that software can be deployed on a variety of commodity hardware types
- [x] Ensure that each project has clear, understandable instructions for setting up a local development environment, and that team members can be quickly added or removed from projects
- [x] Consider open source software solutions at every layer of the stack


**Play 9 Deploy in a flexible hosting environment**

The team evaluated all the questions in Play 9.  Given the state of the Working Prototype, we determined that many of the requirements did not apply at this time.  We hosted the DAAS Working Prototype on AWS.  It is deployed on Docker, making it easy to stand up new containers as needed.  Docker can be managed using a variety of tools such as Kubernetes which  provide "self-healing" capabilities should problems emerge.  While we do not anticipate large volumes of traffic, we have architected the solution that makes it easy to scale vertically and horizontally and throttle based on user demand.  

- [x] Resources are provisioned on demand
- [x] Resources scale based on real-time user demand (Future.)
- [x] Resources are available in multiple regions
- [x] We only pay for resources we use
- [x] Static assets are served through a content delivery network
- [x] Application is hosted on commodity hardware

**Play 10 Automate testing and deployments**

Given the tight timeline for this Working Prototype, automated testing was limited to executing a handful of Unit Tests.  Using Jenkins, we automated builds and deploys, releasing a new product daily and occasionally even more often.  This gave us the opportunity to immediately evaluate DAAS and get feedback. Although the prototype should not expect high volumes, it was architected in a way that would make it easy to scale both vertically and horizontally. See Logical Architecture and the Physical Architecture (Reference Model) described above.  

- [x] Create automated tests that verify all user-facing functionality
- [x] Create unit and integration tests to verify modules and components
- [x] Run tests automatically as part of the build process
- [x] Perform deployments automatically with deployment scripts, continuous delivery services, or similar techniques


**Play 11 Manage security and privacy through reusable processes**

Our team reviewed the Description, Checklist, and Key Questions for Play 11 and determined that security and privacy would be evaluated and addressed in subsequent Epics/Sprints. Given the functionality of DAAS, an area of concern would be protecting user profiles and contact information. The application is accessed via HTTPS, providing a secure commmunication channel for the Working Prototype.  The planned physical environment expects the use of firewalls as depicted in our reference model above. 


**Play 12 Use data to drive decisions**

The team considered various metrics.  We considered using JMeter to ascertain system performance.  We also had a brief discussion about using AppDyanimcs to thoroughly evaluate DAAS. However, we chose to do neither of these things given the timeframe and the fact that doing so was unneeded at this stage of the DAAS Working Prototype. The product is host on AWS Cloud and therefore takes advantage of AWS monitoring. Future Sprints would address issues of performance testing and monitoring. At this stage of the prototype, our focus was funtionality, ease-of-use, and aesthetics.  We gauged succcess in these areas based on user interaction with DAAS. The team created user stories for metrics, which can be found in the backlog. 


**Play 13 Default to open**

The team's emphasis in building the DAAS Working Prototyp is to be completely open.  We used a variety of ways to collect user feedback, but the most productive was having users interact with the prototype and give use either feedback verbally or in writing.  We used OpenAPI to document our inerfaces, and we used completely open technnology and have made our code publicly available via GitHub.  

- [x] Offer users a mechanism to report bugs and issues, and be responsive to these reports (Primarily we used JIRA and Slack.)
- [x] Ensure that data from the service is explicitly in the public domain
- [x] Catalog data in the agency’s enterprise data inventory and add any public datasets to the agency’s public data listing (Users can tag knowledge articles.)
- [x] Ensure that we maintain the rights to all data developed by third parties in a manner that is releasable and reusable at no cost to the public
- [x] Ensure that we maintain contractual rights to all custom software developed by third parties in a manner that is publishable and reusable at no cost
- [x] When appropriate, publish source code of projects or components online
- [x] When appropriate, share your development process and progress publicly




## RFI Requirements 

**Requirement A: Assigned one (1) leader and gave that person authority and responsibility and held that person accountable for the quality of the prototype submitted;**

Our team selected Suresh Kannan to serve as the product owner with authority and responsibility for defining product scope and verifying completeness. He was ultimately accountable for delivery of the working prototype. Mr. Kannan has 20 years of Information Technology experience in software product development, implementation, and Agile delivery.  

On this effort, he worked with users to gather feedback, provided guidance on wireframes, and helped craft User Stories. He helped with backlog grooming and prioritizing Stories as high, medium, and low.  Team members were encouraged to select which User Stories they wanted to develops. At times, however, the Product Manager made assigments based on the priorities. 

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

The QualApps team collectively reviewed the RFI to understand product requirements. Uder the Product Director's guidance, the team discussed how the solution would be architected based on the RFI.  The team collaborated on User Stories. Our Business Analyst conducted internet-based research on knowledge-sharing concepts and application features.  The research resulted in new and refined User Stories. The team's goal was to quickly develop a simple, elegant application that meets functional needs and compliance requirements -- ADA, WCAG 2.0. 

We included colleagues outside of our QualApps team to discuss basic functionality and review wireframes and mock-ups.  These same individuals also reviewed multiple iterations of the prototype and providede feedback on how we could make improvements. 

**Requirement D: Used at least a minimum of three (3) “user-centric design” techniques and/or tools**

The team used a number of user-centric design techniques.  To begin with, our Business Analyst conducted research on knowledg-sharing platforms.  He evaluated various platforms, look-and-feel, feedback mechanisms, moderator activity, ways to collapse comments, to name just a few features.  Findings were discussed with the team, and the Product Backlog was updated accordingly.

Our team members also <a href="https://github.com/jpuli/pqvp/blob/master/interview.md">interviewed</a> a colleague that served as an end user for the DAAS product.

The team evaluated User Personas.  We considered various types of individuals that would interact with the system.  Since the context is a knowledge sharing platform for government employees, we considered the types of personas that might benefit from this application.  We addressed three personas: 1) Bob, the seasoned employee looking forward to transitioning into retirement, 2) Jim, the millenial just starting off in his career, and 3) Susan, the manager who is concerned about workforce development and ensuring that as employees retire and new employees move in to take their place that knowledge transfer occurs.

To evaluate the initial set product features and workflow, the DAAS development team developed wireframes.  This effort helped take our unpolished ideas about the product to the next level.  It gave us insight into function, navigation, and even aesthetics.  This effort made it clear that our emphasis should be on simplicity.

As the prototype was developed, colleagues interacted with the system and gave us feedback on its form and function.  We also researched and usability testing.


**Requirement E: Used GitHub to document code commits**

The team used GitHub our source code management tool for daily code commits. We also used GitHub for storing documents related to the prototype.

**Requirement F: Used OpenAPI to document the RESTful API, and provided a link to the OpenAPI**

The solution uses OpenAPI to document RESTful APIs. <a href="http://daas.qualapps.com/swagger-ui.html">View our use of OpenAPI here. </a>

**Requirement G: Complied with Section 508 of the Americans with Disabilities Act and WCAG 2.0**

To comply with WCAG, our team used HTML5 and CSS3 technology during front end development. Once built, the code was tested against the W3 standard site. This methodology supports compliance with Section 508 of the Americans with Disabilities Act. 

**Requirement H: Created or used a design style guide and/or a pattern library**

We conformed to the <a href="https://designsystem.digital.gov">US Web Design Standards</a>.  The team created a basic <a href="https://github.com/jpuli/pqvp/blob/master/style%20guide/qualapps-styleguide.pdf">style guide</a>.

**Requirement I: Performed usability tests with people**

As part of our user-centric approach we conducted usability testing via <a href="https://github.com/jpuli/pqvp/blob/master/interview.md">surveys</a>  of wireframes and prototypes.  The team evaluated responses from the usability exercises and updated the product backlog.  As a result, the team created new stories.


**Requirement J: Used an iterative approach, where feedback informed subsequent work or versions of the prototype**

From start-to-finish, the team used an interative approach.  This began by working with users to evaluate wireframes, and very soon after that, multiple iterations of the DAAS Working Prototype.  We entered features and bugs into Jira, incorporated them into Sprints, made fixes, redeployed, and retested. 

**Requirement K: Created a prototype that works on multiple devices, and presents a responsive design** 

Our DAAS Working Prototype runs on multiple devices and is fully responsive. 

**Requirement L: Used at least five (5) modern and open-source technologies, regardless of architectural layer (frontend, backend, etc.)**

As referenced in other sections of this document, the team selected multiple open source tools to develop the working prototype: JQuery, HTML5, Bootstrap, OpenAPI, Java, Spring Boot, Linux/Docker, NGINX, Postgres.  We also used a number of open source tools to design and build the solution.  

**Requirement M: Deployed the prototype on an Infrastructure as a Service (IaaS) or Platform as Service (PaaS) provider, and indicated which provider they used**

The QualApps team deployed the solution on Docker on AWS. 

**Requirement N: Developed automated unit tests for their code**

The team used Jenkins CI pipline automate unit testing. 

**Requirement O: Setup or used a continuous integration system to automate the running of tests and continuously deployed their code to their IaaS or PaaS provider**

The team used Jenkins server automated testing and CI/CD.  View our <a href="http://ec2-52-88-115-151.us-west-2.compute.amazonaws.com:8080/">Jenkins Server</a> here.

**Requirement P: Setup or used configuration management**

The team used Github for CM and source control. 

**Requirement Q: Setup or used continuous monitoring**

The appliation can make use of out-of-the-box AWS monitoring. 

**Requirement R: Deployed their software in an open source container, such as Docker (i.e., utilized operating-system-level virtualization)**

The team used Docker version 17.12.0-ce on our deployed staging server.

**Requirement S: Provided sufficient documentation to install and run their prototype on another machine**

Installation instructions are found in the <a href="https://github.com/jpuli/pqvp/blob/master/INSTALL.md">deployment guidlines</a>.


**Requirement T: Prototype and underlying platforms used to create and run the prototype are openly licensed and free of charge**

The entire prototype is openly licensed: Docker, Thymeleaf, Java, Junit, Maven, Git, JQuery, Jenkins, Docker-Compose, AWS, Postgres. 
