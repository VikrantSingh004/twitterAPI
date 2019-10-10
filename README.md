# twitterAPI.connect

Connect is maven based Spring boot server program which is inteded to host a web service.
this web service will recieve two username of twitter account in HTML form hosted at  http://localhost:8080/getMutualFollowers
and on submit it will return common followers of those user1 and user2.

Work flow: 

/getMutualFollowers is mapped inside userInfoController.java as a GET method which returns a manually HTML based web page containing a form and data list below.
After submitting userid in form, userInfoController will be redirected to twitterContoller which will internally call twitter api and retrieve followers list for both users. since twitter has restricted on bulky request for student developer credential, i am using API's on my personal twitter account which has less followers to avoid rate limit exceed error.
After succesful return of followers list of both users, it will simply retain all common followers id and rerturn this in same HTML page in list below form.
Please refer screenshots for more crearity.

Restriction:
Twitter Api has limit for hourly requests hence testing this application was not possible for celerities accounts which has huge no of followers.
It may require to restart application as it sometimes looses connection with twitter api over time and due to connectivity issue. I have simply not covered for exception handling so please don't mind errors on out of scope testing.
