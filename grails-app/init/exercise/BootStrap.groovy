package exercise

class BootStrap {


    def init = { servletContext ->

        new Announcement(
                articleName: 'Flying Fisherman Passport Spin Rod 10-17lb P046',
                articleDescription: 'Flying Fisherman Passport Medium Weight Spinning Rod can handle anything from the Amazon\'s peacock bass, to mid-sized tarpon and permit in the Keys, trophy steelheads in Britich Colombia, average size golden dorado in Argentina and more.',
                quantity: 2,
                address: 'Vulkanstrasse 106. CH-8010 Zurich Switzerland ',
                email: 'juanito.perez@hotmail.com',
                username: 'juanitop',
                phoneNumber: '1234567890',
                finalizationDate: new Date().plus(29)).save()

        new Announcement(
                articleName: 'TaylorMade 2018 M4 10.5 Driver Atmos 5r Graph Reg',
                articleDescription: 'By providing more loft in the high-toe and less loft in the low-heel, this groundbreaking technology produces more consistent side spin in the areas',
                quantity: 1,
                address: 'Brown Boveri Platz 3b. Baden',
                email: 'test@test.ch',
                username: 'culeroConor',
                phoneNumber: '41585850000',
                finalizationDate: new Date().plus(40)).save()

        new Announcement(
                articleName: 'COB Ceiling Spot Light 3w 5w 7w 12w LED ceiling recessed Lights Indoor Lighting',
                articleDescription: 'AC85-245V Luminous Intensity:3w=450lm 5w=600lm 7w=750lm 12w=900lm Dimensions: 85mm (D) x 68mm (H) Open Hole: 70-75mm Beam Angle: 60degrees Power:12W LED working temperature: -25°C - +65°C Weight: 100g(light+driver)',
                quantity: 3,
                address: 'Hotelstrasse 1. CH-8058 Zurich Airport ',
                email: 'anotheremail@test.ch',
                username: 'cangshi',
                phoneNumber: '99939495832',
                finalizationDate: new Date().plus(12)).save()

        new Announcement(
                articleDescription: 'Height: 2.4m/94.4inch Hem perimeter: 9m/354inch Steel ring diameter: 0.6m/23.6inch Mesh density: 21 holes / square centimeter [Package Included]:1 x Mosquito Net',
                articleName: 'Elegant Hung Dome Mosquito Nets For Summer Polyester Mesh Fabric Home Textile Bulk Accesso',
                quantity: 1,
                address: 'Banhofstrasse 23. CH-8020 Zurich ',
                email: 'anotheremail@test.ch',
                username: 'argemiro',
                phoneNumber: '999322495832',
                finalizationDate: new Date().plus(2)).save()

        new Announcement(
                articleDescription: 'Confidence Golf LEFTY POWER Hybrid Club Set & Stand Bag',
                articleName: 'unused, unopened, undamaged item in its original packaging (where packaging is applicable).',
                quantity: 1,
                address: 'Talacker 24 8001 Zurich',
                email: 'anotheremail@test.ch',
                username: 'argemiro',
                phoneNumber: '999322495832',
                finalizationDate: new Date()).save()

        new Announcement(
                articleName: 'Celular Motorola Moto G6 Plus + Auriculares Pulse Max',
                articleDescription: 'selfies de 8MP con flash LED y más: la cámara del moto g6 plus reconoce puntos turísticos, objetos y te da información en segundos',
                quantity: 1,
                address: 'Carrera 59 Numero 16-53, Medellin Colombia',
                email: 'santiagollano4@gmail.com',
                username: 'sllanoj',
                phoneNumber: '3102570216',
                finalizationDate: new Date().plus(200)).save()
    }
    def destroy = {
    }
}