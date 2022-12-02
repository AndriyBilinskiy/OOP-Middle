<mark>Decsription</mark>

This is the web service to get information about companies.

<img width="560" alt="Screen Shot 2022-12-02 at 10 18 20 PM" src="https://user-images.githubusercontent.com/33194709/205378623-15bc39fa-d682-440e-8c12-3666c7492cbc.png">
Here is the example how to use it and of the result. The input should be the domain of the company.

It is also possible to add information about company using POST request to
this adress http://midterm-env.eba-rvm2hdun.eu-central-1.elasticbeanstalk.com/companies/edit.


And pass json wiht info like that 


{ "name": "Ukrainian Catholic University",
  "twitter": "https://twitter.com/ucu_university",
  "facebook": "https://www.facebook.com/UkrainianCatholicUniversity",
  "logo": "https://mywebsite.com/logo.png",
  "icon": "https://mywebsite.com/icon.png",
  "employees": "501-1000",
  "address": "17 Sventsitskoho street, Lviv, Ukraine" }


<mark>Patterns</mark>

In this assignment we used strategy, façade, template, creator, controller, and indirection patterns.

•	Strategy pattern we used for all classes that implement Strategy interface. We searched information about company in Google, Brandfetch, PDL company dataset, Wikipedia, and tried finding name in domain webpage. Essentially classes BrandFetchStrategy, PDLParsingStrategy, GoogleSearchStrategy, WikiParsingStrategy, and DomainParsingStrategy do the same thing: they find and record all information about company that can theoretically be stored in that one place. However, as the ways of getting and processing information are different for every source, we separated lookup into different classes for every place where we search.
•	CompanyService is a façade for CompanyRepository. CompanyService stores CompanyRepository object and defines the only two functions that we need from CompanyRepository. As CompanyRepository extends library class which has a lot of redundant methods, with CompanyService class we limited what we can do with CompanyRepository to only the things which we need.
•	Creator pattern is used when CompanyController creates StrategiesMerger and when StrategiesMerger creates instances of MostFrequent. Strategies merger is only needed by CompanyController, so there is no reason to create instances of this object outside this class. Also we only need to find most frequent value of the field when merging results of different strategies, so we create search class only when merging.
•	Controller pattern is used in CompanyController class. This class delegates tasks of processing and storing data to StrategiesMerger and CompanyService, puts together their work, and is responsible for producing final result.  
•	Indirection – we have CompanyService class which provides interaction between CompanyController and CompanyRepository, and StrategiesMerger, which connects CompanyController to all Strategies.
•	Template – Company Repository uses GpaRepository class as a template.

