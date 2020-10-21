# to generate core file execute in bash:
#    ulimit -c unlimited

.PHONY: clean cleanall

OBJS=utils.o thread.o process.o

CPPFLAGS=-static -Wall -ggdb -pthread
#CPPFLAGS=-Wall -ggdb -rdynamic -pthread
SYMBOLS=-DEXIT_POLICY            # -DEXCEPTION_POLICY or -DEXIT_POLICY

all: libsoconcur.a

install: all
	cp -af libsoconcur.a ../lib
	cp -af *.h ../include

libsoconcur.a: $(OBJS)
	ar -r $@ $^

%.o: %.cpp
	$(CXX) $(SYMBOLS) $(CPPFLAGS) -c $<

clean:
	rm -fv $(OBJS) core

cleanall: clean
	rm -fv libsoconcur.a

