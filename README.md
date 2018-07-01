# Concurrency Project

This project was created in order to improve the knowledge with threads, concurrency data and design patterns, it uses an adapter factory pattern to retrieve the filters.
Also it adds an Observer patter in order to update all filters every day at 2am.

The app allows you to read a JSON object through a certain URL and let you filter it's information by a different kind of topics:

0 - EftelingUsers (Socials for user "efteling")

1 - SocialsWithDisney (Socials containing: "disney")

2 - SocialsWithoutDisney (Socials without: "disney")

3 - SocialsWithVideoContent (Socials with video content)

4 - SocialsBeforeFeb (Socials created before february 1st)

5 - SocialsAfterFeb (Socials created after february 1st)

6 - FacebookSocials (Only Facebook socials)

Also it adds one more option which is:

7 - Execute 20 parallel threads, Allows the user to execute 20 parallel threads that will request random filters all at the same time.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Eric Jaen** 