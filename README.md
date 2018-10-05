# McKessonSamples

There are two folders each containing my solution to one of the the two problems provided by McKesson.

The first folder, AlternatingIterator is an Eclipse Java8 Gradle project that contains an implementation for the AlternatingIterator interface and test cases to ensure the expected functionality.

	To run the test cases:
		1) Clone the McKessonSamples repository, if it isn't
		2) Open a command prompt
		3) Navigate to the AlternatingIterator directory
		4) Type the following command 
				'gradlew build && gradlew test' and press enter
		5) Test cases should execute in the command prompt

The second folder, McKessonRestApi is an Eclipse Java8 Gradle Spring Boot project that contains an implementation of a single rest end point that allows a user to added and test cases to ensure the expected functionality.

	To start the rest service:
		1) Clone the McKessonSamples repository, if it isn't
		2) Open a command prompt
		3) Navigate to the McKessonRestApi directory
		4) Type the following command 
				'gradlew build && java -jar build/libs/McKessonRestApi-0.0.1-SNAPSHOT.jar' 
				and press 	enter
		5) The rest service should start
		6) Open a rest client
		7) Create a new request with the follow:
				Method: Put
				URL: http://localhost:8383/user/1
				Header Name: content-type
				Header Value: application/json
				Body Content Type: application/json
				Body: {"name":"Derek Bodin","email":"derek.bodin@mckesson.com"}
		8) Click the send or submit button
		9) A 200 response should be returned with the following body
				Body: {"id":1,"name":"Derek Bodin","email":"derek.bodin@mckesson.com"}		

	To run the test cases:
		1) Clone the McKessonSamples repository, if it isn't
		2) Open a command prompt
		3) Navigate to the McKessonRestApi directory
		4) Type the following command 
				'gradlew build && gradlew test' and press enter
		5) Test cases should execute in the command prompt
