.SUFFIXES: .java .class
SRCDIR=src/typingTutor
BINDIR=bin
DOCDIR=doc

${BINDIR}/%.class:${SRCDIR}/%.java
	javac $< -cp ${BINDIR} -d ${BINDIR}

CLASSES=WordDictionary.class Score.class ScoreUpdater.class HungryWordMover.class FallingWord.class WordMover.class CatchWord.class GamePanel.class TypingTutorApp.class
CLASS_FILES=${CLASSES:%.class=${BINDIR}/%.class}

default:	${CLASS_FILES}

.PHONY:	run

clean:
	rm ${BINDIR}/typingTutor/*.class

docs:
	javadoc -classpath ${BINDIR} -d ${DOCDIR} ${SRCDIR}/*.java

run:
	java -cp bin typingTutor.TypingTutorApp ${ARGS}


cleandocs:
	rm -rf ${DOCDIR}/*
