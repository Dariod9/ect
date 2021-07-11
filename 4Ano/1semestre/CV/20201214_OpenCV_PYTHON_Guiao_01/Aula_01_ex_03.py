# Aula_01_ex_01.py
#
# Example: loading and displaying an image with OpenCV
#
# Paulo Dias - 10/2019


# import
import numpy as np
import cv2

# Read the image
image = cv2.imread("deti.jpg", cv2.IMREAD_UNCHANGED)
image2 = cv2.imread("deti.bmp", cv2.IMREAD_UNCHANGED)
image3=image-image2
if np.shape(image) == ():
    # Failed Reading
    print("Image file could not be opened")
    exit(-1)

# Image characteristics
#height, width = image.shape
#
# print(image[2,4])
#
# for a in range(512):
#     for b in range(512):
#         if image[a,b] < 128:
#             #print("TESTE")
#             image2[a,b] = 0

# Create a visualization window
# CV_WINDOW_AUTOSIZE : window size will depend on image size
cv2.namedWindow("Display window", cv2.WINDOW_AUTOSIZE)
cv2.namedWindow("Display window2", cv2.WINDOW_AUTOSIZE)
cv2.namedWindow("Display window3", cv2.WINDOW_AUTOSIZE)

# Show the image
cv2.imshow("Display window", image)
cv2.imshow("Display window2", image2)
cv2.imshow("Display window3", image3)


# Wait
cv2.waitKey(0)

# Destroy the window -- might be omitted
cv2.destroyWindow("Display window")
