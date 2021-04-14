# SpotPer API

> REST API for **SpotPer** application. Personalized Spotify-like system.

> Spring Boot + JPA / Hibernate + Microsoft SQL Server

> *Trabalho final da disciplina de **Fundamentos de Bancos de Dados** da **Universidade Federal do Ceará***.

## Introduction

### Overview

 - Creates and manages database entities.
 - Includes basic requests for  all tables, and personalized queries for
   Albums / Playlists / Tracks requests.
 - Cross Origin Resource Sharing is enabled for all requests   
   availble, allowing this service to be used on any other domain, port
  or scheme.

  

### Authentication

No authentication required

  

### Error Codes

``` HTTP STATUS: 404 ```

Can occur upon trying to GET / PUT / DELETE an object by ID, whereas the ID is invalid.

``` HTTP STATUS: 500 ```

Can occur upon: 

 - Trying to POST an object into a Join Table enitity with the same
   Composite Primary Key as an existing object in the Database.
 - Trying to POST an object with the incorrect json attributes format (*See correct examples below*) 

## Installation and Setup Instructions
### Requirements

 - [ ] JDK 14 
 - [ ] Maven 4.0+
 - [ ] Microsoft SQL Server 2019 Express + Management System
 - [ ] Any IDE supporting Spring Framework

Connect to SQL Server Express with SQL Server Authentication, and create your database.
Clone down this repository and import the Maven project into your chosen IDE. Then, run `mvn clean install` . 
On **src/main/resources/application.properties**, add the following code (replacing `???` with your database info):

```properties
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver  
spring.datasource.url=jdbc:sqlserver://localhost;databaseName=???  
spring.datasource.username=???  
spring.datasource.password=???
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql = true  
  
## Hibernate Properties  
# The SQL dialect makes Hibernate generate better SQL for the chosen database  
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.SQLServer2012Dialect  
  
# Hibernate ddl auto (create, create-drop, validate, update)  
spring.jpa.hibernate.ddl-auto = update
```
Finally, run **src/main/java/spotper/api/SpotperApiApplication.java**

## API Endpoints Info

### Album
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /albums | None | None | 200 | None | Get all albums
| `GET` | /albums/{id} | None | None | 200 | 404  | Get album by ID
| `POST` | /albums | None | *Examples below* | 201 | 500 | Create new album
| `PUT` | /albums/{id} | None | *Examples below* | 200 | 404 | Edit album by ID
| `DELETE` | /albums/{id} | None | None | 204 | 404 | Delete album by ID

### Artist
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /artists| None | None | 200 | None | Get all artists
| `GET` | /artists/{id} | None | None | 200 | 404  | Get artist by ID
| `POST` | /artists| None | *Examples below* | 201 | 500 | Create new artist
| `PUT` | /artists/{id} | None | *Examples below* | 200 | 404 | Edit artist by ID
| `DELETE` | /artists/{id} | None | None | 204 | 404 | Delete artist by ID

### Composer
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /composers| None | None | 200 | None | Get all composers
| `GET` | /composers/{id} | None | None | 200 | 404  | Get composer by ID
| `POST` | /composers| None | *Examples below* | 201 | 500 | Create new composer
| `PUT` | /composers/{id} | None | *Examples below* | 200 | 404 | Edit composer by ID
| `DELETE` | /composers/{id} | None | None | 204 | 404 | Delete composer by ID

### Composition
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /compositions| None | None | 200 | None | Get all compositions
| `GET` | /compositions/{id} | None | None | 200 | 404  | Get composition by ID
| `POST` | /compositions| None | *Examples below* | 201 | 500 | Create new composition
| `PUT` | /compositions/{id} | None | *Examples below* | 200 | 404 | Edit composition by ID
| `DELETE` | /compositions/{id} | None | None | 204 | 404 | Delete composition by ID

### Label
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /labels| None | None | 200 | None | Get all labels
| `GET` | /labels/{id} | None | None | 200 | 404  | Get label by ID
| `POST` | /labels| None | *Examples below* | 201 | 500 | Create new label
| `PUT` | /labels/{id} | None | *Examples below* | 200 | 404 | Edit label by ID
| `DELETE` | /labels/{id} | None | None | 204 | 404 | Delete label by ID

### Label Phone
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /labelPhones| None | None | 200 | None | Get all label phones
| `GET` | /labelPhones/{id} | None | None | 200 | 404  | Get label phone by ID
| `POST` | /labelPhones| None | *Examples below* | 201 | 500 | Create new label phone
| `PUT` | /labelPhones/{id} | None | *Examples below* | 200 | 404 | Edit label phone by ID
| `DELETE` | /labelPhones/{id} | None | None | 204 | 404 | Delete label phone by ID

### Musical Periods
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /musical_periods| None | None | 200 | None | Get all musical periods
| `GET` | /musical_periods/{id} | None | None | 200 | 404  | Get musical period by ID
| `POST` | /musical_periods| None | *Examples below* | 201 | 500 | Create new musical period
| `PUT` | /musical_periods/{id} | None | *Examples below* | 200 | 404 | Edit musical period by ID
| `DELETE` | /musical_periods/{id} | None | None | 204 | 404 | Delete musical period by ID

### Playlist
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /playlists| None | None | 200 | None | Get all playlists
| `GET` | /playlists/{id} | None | None | 200 | 404  | Get playlist by ID
| `POST` | /playlists| None | *Examples below* | 201 | 500 | Create new playlist
| `PUT` | /playlists/{id} | None | *Examples below* | 200 | 404 | Edit playlist by ID
| `DELETE` | /playlists/{id} | None | None | 204 | 404 | Delete playlist by ID

### Track
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `GET` | /tracks| None | None | 200 | None | Get all tracks
| `GET` | /albums/{id}/tracks| None | None | 200 | None | Get all tracks from an album
| `GET` | /playlists/{id}/tracks| None | None | 200 | None | Get all tracks from a playlist
| `GET` | /tracks/{id} | None | None | 200 | 404  | Get track by ID
| `POST` | /tracks| None | *Examples below* | 201 | 500 | Create new track
| `PUT` | /tracks/{id} | None | *Examples below* | 200 | 404 | Edit track by ID
| `DELETE` | /tracks/{id} | None | None | 204 | 404 | Delete track by ID

### Composer/Musical Period join table
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `POST` | /composers/musical_periods| None | *Examples below*| 201 | 500 | Create new composer and musical period relation 
| `DELETE` | /composers/musical_periods | composerId *(required)*, periodId *(required)*| None | 204 | 404  | Delete composer and musical period relation by composite ID

### Composer/Track join table
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `POST` | /composers/tracks| None | *Examples below*| 201 | 500 | Create new composer and track relation 
| `DELETE` | /composers/tracks| composerId *(required)*, trackId *(required)*| None | 204 | 404  | Delete composer and track relation by composite ID

### Track/Artist join table
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `POST` | /tracks/artists | None | *Examples below*| 201 | 500 | Create new track and artist relation 
| `DELETE` | /tracks/artists | trackId *(required)*, artistId *(required)*| None | 204 | 404  | Delete track and artist relation by composite ID


### Track/Playlist join table
|HTTP Method| Path | Params | Body | Success | Error | Description
|--|--|--|--|--|-- | --
| `POST` | /tracks/playlists | None | *Examples below*| 201 | 500 | Create new track and playlist relation 
| `DELETE` | /tracks/playlists | trackId *(required)*, playlistId *(required)*| None | 204 | 404  | Delete track and playlist relation by composite ID

## `POST` Json Examples

```json
//LABEL
{
  "labelName": "Apple Records",
  "address": "27 Ovington Street",
  "homepage": null

}
//LABEL PHONE
{
  "id":{"phoneNumber": 999555},
  "phoneType": "Cellphone",
  "label":{"id":3}
}
//ALBUM
{
  "albumDescription": null,
  "label":{"id":3},
  "purchasePrice": 15.55,
  "purchaseDate": "2012-04-23T18:25:43.511Z",
  "purchaseType": "Online",
  "recordingDate": "1969-04-23T18:25:43.511Z",
  "albumName": "Abbey Road",
  "albumCover": "https://i.scdn.co/image/ab67616d0000b273dc30583ba717007b00cceb25"
}
//COMPOSER
{
  "composerName": "Paul Mccartney",
  "birthDate": "1942-06-18T04:17:43.030+00:00",
  "deathDate": null,
  "city": "Liverpool",
  "country": "United Kingdom"
}
//COMPOSITION
{
  "compositionDescription": "Based on a 17th century poem by Thomas Dekker called Golden Slumbers Kiss Your Eyes ",
  "compositionType": "Rock"
}
//MUSICAL PERIOD
{
  "periodDescription": "Modern Period",
  "duration":"1910s-current day"
}
//COMPOSER-PERIOD
{   
  "id": {},
  "composer": {"id":12},
  "musicalPeriod":{"id":13}
}
//PLAYLIST
{   
  "playlistName": "60s Rock"
}
//ARTIST
{
  "artistName": "The Beatles",
  "artistType": "Band"
}
//TRACK
{
  "trackName": "Golden Slumbers",
  "trackDuration": 2.5,
  "trackDescription": null,
  "recordingType": "Stereo",
  "trackNumber": 14,
  "album":{"id":16},
  "composition":{"id":8}
}
//COMPOSER-TRACK
{   
  "id": {},
  "composer": {"id":12},
  "track":{"id":17}
}
//TRACK-ARTIST
{   
  "id": {},
  "track": {"id":17},
  "artist":{"id":15}
}
//TRACK-PLAYLIST
{   
  "id": {},
  "track": {"id":17},
  "playlist":{"id":14}
}

```
