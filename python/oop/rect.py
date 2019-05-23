class rect:

    id = 0

    def __init__(self,length, height):
        self.id = self.id+1 
        self.length=length
        self.height=height

    def surf(self):
        return self.height * self.length

    def getId(self):
        return self.id

    def getHeight(self):
        return self.height

    def getLength(self):
        return self.length
