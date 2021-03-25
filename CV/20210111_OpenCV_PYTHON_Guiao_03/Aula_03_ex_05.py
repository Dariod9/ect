# Aula_03_ex_04.py
#
# Sobel Operator
#
# Paulo Dias - 10/2019


import cv2
import numpy as np
import sys


##########################
# Print Image Features

def printImageFeatures(image):
    if len(image.shape) == 2:
        height, width = image.shape
        nchannels = 1
    else:
        height, width, nchannels = image.shape

    print("Image Height:", height)
    print("Image Width:", width)
    print("Number of channels:", nchannels)
    print("Number of elements:", image.size)


###################################
# MAIN

# image = cv2.imread(sys.argv[1], cv2.IMREAD_UNCHANGED)

# if np.shape(image) == ():
#     # Failed Reading
#     print("Image file could not be open!")
#     exit(-1)

# printImageFeatures(image)
# image=cv2.resize(image,(300,300))
# image2=cv2.Canny(image,100,75)
# cv2.imshow('Original', image)
# cv2.imshow('NAO Original', image2)


# cv2.waitKey(0)
capture = cv2.VideoCapture(0)
while (True):
    ret, frame = capture.read()
    frame=cv2.Canny(frame,100,75)
    cv2.imshow('video', frame)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break
capture.release()
cv2.destroyAllWindows()

cv2.destroyAllWindows()
