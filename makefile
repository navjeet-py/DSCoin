all: clean compile

compile:
	javac DSCoinPackage/*.java

clean:
	find . -name '*.class' -exec rm -f {} \;