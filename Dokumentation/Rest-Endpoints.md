  # REST-Endpoints
## Album
### AlbumDTO
```
{
    title: String,
    band: long,
    releaseDate: LocalDate,
    label: Stirng,
    price: BigDecimal
}
```

### Endpoint
```
paths:
    /album
        post:
            request:
                object: AlbumDTO
            responses:
                201: AlbumDTO
                400
    /album/health
        get:
            response:
                200
```

## Band
### BandDTO
```
{
    bandId: Long,
    bandname: String,
    genre: String,
    foundingDate: LocalDate,
    bandMembers: Integer,
    dissolutionDate: LocalDate
}
```

### Endpoint
```
paths:
    /bands
        post:
            request:
                object: BandDTO
            responses:
                201: BandDTO
                400
        get:
            response:
                200: [BandDTO, ...]

    /bands/{id}
        get:
            parameters:
                name: id
                type: long
            response:
                200: BandTO
                404
```
