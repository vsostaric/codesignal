const garage = {
    numberOfCars: 3,
    attendingGuard: {
        name: 'John',
        age: 33
    }
}

const garageCopy = {
    ...garage
}

console.log(
    `Garage copy is: ${JSON.stringify(garageCopy)}`
)

garage.numberOfCars = 77
garage.attendingGuard.name = 'Tom'
garage.attendingGuard.age = 29

console.log(
    `Garage copy is: ${JSON.stringify(garageCopy)} -> After change`
)

console.log(`Javascript is a pass by value language. But for objects, the value is their reference.`)
console.log(`Meaning the primitive number was not changed, but the object was changed by reference.`)
