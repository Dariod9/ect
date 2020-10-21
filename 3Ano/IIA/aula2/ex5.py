def main():

    exe=lambda f,g,h : lambda x,y,z : h(f(x,y), g(y,z) )
    nova= exe(lambda x,y: x+y, lambda x,y: x*y, lambda x,y: x<y)
    print(nova(2,3,4))


main()