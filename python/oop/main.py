from rect import *

r1 = rect(10, 5)
r2 = rect(2, 3)

tab = []
tab.append(r1)
tab.append(r2)

for shape in tab:
    print(shape,
        shape.getHeight(),'x', shape.getLength(),
        ', surface = ', shape.surf()
        )
