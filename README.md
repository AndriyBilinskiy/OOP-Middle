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
