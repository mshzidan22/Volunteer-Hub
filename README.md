# Volunteer-Hub


## Overview

Volunteer-Hub is a Java Spring Boot application designed to promote sustainability awareness by facilitating volunteer participation in various eco-friendly activities. The application supports two types of users: Initiators and Volunteers. Initiators can propose sustainability initiatives, and Volunteers can register for and participate in these initiatives.

## Features

### Admin

- **Login:** The Admin can sign in and logout with the predefined credentials.
- **Initiative Approval:** Approve or reject initiatives proposed by users.
- **Initiative Management:** Remove initiatives, initiators, or volunteers.
- **View Initiatives:** See all initiatives in a tabular form.
- **Search:** Search for initiatives or volunteers by name.
- **View Details:** View details of each initiative, initiator, or volunteer.

### User

- **Signup:** Users must sign up initially to log in.
- **Initiator:** Users can propose, edit, and delete initiatives.
- **Volunteer:** Users can register for and withdraw from initiatives, gaining points for participation.
- **Personal Information:** Users can edit their personal information at any time.
- **Initiative Management:** Initiators can view registered volunteers for their initiatives.
- **Limitations:** Initiators can have a maximum of two active initiatives.
- **Volunteer Dashboard:** Volunteers can see all active initiatives.
- **Withdrawal:** Volunteers can withdraw from initiatives before they expire.
- **Points System:** Volunteers gain points for participation and lose points for withdrawal.
- 
### Initiative
- **Attributes:** Auto-generated id, name, date, time, credit points, description, status (expired/active), initiator name, and volunteers list.
- **Expiration:** Initiatives expire if the date and time have passed, preventing new volunteer registrations.
- **Types:** Initiatives can include various eco-friendly activities such
-  as donation drives, clean-up events, planting initiatives, recycling projects, and more.

## API Endpoints

### Initiative Controller

- `GET /api/initiatives/{id}`
- `PUT /api/initiatives/{id}`
- `DELETE /api/initiatives/{id}`
- `GET /api/initiatives`
- `POST /api/initiatives`
- `POST /api/initiatives/{id}/register`

### Account Controller

- `PUT /api/account/edit/{accountId}`
- `POST /api/account/signup`

### Admin Controller

- `POST /admin/initiatives/{id}/deny`
- `POST /admin/initiatives/{id}/approve`
- `GET /admin/initiatives`
- `GET /admin/initiatives/{id}`
- `DELETE /admin/initiatives/{id}`
- `GET /admin/initiatives/search/{name}`
- `GET /admin/initiatives/pending`
- `DELETE /admin/initiatives/{initiativeId}/volunteers/{userId}`
- `GET /api/users/{id}`
- `GET /admin/users`
- `GET /admin/users/{id}`
- `DELETE /admin/users/{id}`

## Technologies Used

- **Spring Boot:** 
- **Spring JPA:** 
- **Spring Security:**
- **PostgreSQL:** 
- **Swagger:** 
- **Docker:** 
