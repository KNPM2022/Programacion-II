import matplotlib.pyplot as plt

# Clase Punto
class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f'({self.x}, {self.y})'

# Clase Línea
class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f'Línea[{self.p1}, {self.p2}]'

    def dibuja_linea(self):
        plt.plot([self.p1.x, self.p2.x], [self.p1.y, self.p2.y], marker='o', color='b')

# Clase Círculo
class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f'Círculo[centro={self.centro}, radio={self.radio}]'

    def dibuja_circulo(self):
        circulo = plt.Circle((self.centro.x, self.centro.y), self.radio, edgecolor='r', facecolor='none')
        plt.gca().add_patch(circulo)

# Ejemplo de uso
if __name__ == '__main__':
    plt.figure()
    plt.axis('equal')
    plt.grid(True)

    # Dibuja la línea
    p1 = Punto(1, 2)
    p2 = Punto(4, 6)
    linea = Linea(p1, p2)
    print(linea)
    linea.dibuja_linea()

    # Dibuja el círculo
    centro = Punto(6, 4)
    circulo = Circulo(centro, 2)
    print(circulo)
    circulo.dibuja_circulo()

    plt.show()
