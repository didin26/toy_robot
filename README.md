INSTALLATION

install Commands
		mvn clean install

Run Application Commands
		java -jar target/robot-0.0.1-SNAPSHOT.jar

AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Robot Commands
        left: LEFT will rotate the robot 90 degrees in the specified direction without changing the position of the robot
        move: MOVE will move the toy robot one unit forward in the direction it is currently facing
        place: initiate place position
        report: REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient
        right: RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot