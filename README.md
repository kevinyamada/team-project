# Team Project

Please keep this up-to-date with information about your project throughout the term.

The readme should include information such as:
- a summary of what your application is all about
- a list of the user stories, along with who is responsible for each one
- information about the API(s) that your project uses 
- screenshots or animations demonstrating current functionality

By keeping this README up-to-date,
your team will find it easier to prepare for the final presentation
at the end of the term.

# Pinterest-Inspired Image Discovery Application

A Java application that allows users to search for images, create and manage boards and pins, customize their profiles, and receive personalized image recommendations.

**Tech Stack:** Java, Java Swing, Unsplash API, JSON, JUnit

## Project Progress Tracker

### Team Responsibilities

| ID | Feature | Assigned To | Status |
|---|---|---|---|
| 1 | Account Registration & Login | Matthew | ⬜ Not Started |
| 2 | Image Search & Browsing | Kevin | ⬜ Not Started |
| 3 | Personalized Recommendations | Kevin | ⬜ Not Started |
| 4 | Pin Management & Persistence | Alex | ⬜ Not Started |
| 5 | Board Management | Gabriel | ⬜ Not Started |
| 6 | User Profile Customization | Kieran & Matthew | ⬜ Not Started |

---

## 1. Account Registration & Login — Matthew

**User Story:** As a user, I want to create an account and log in so that my boards and preferences are associated with my profile.

**Use Cases:**
- Register User
- Log In
- Account Retrieval

**Tasks:**
- [ ] Create `User` entity
- [ ] Implement registration
- [ ] Implement login and authentication
- [ ] Implement account retrieval
- [ ] Store user data in `users.json`
- [ ] Implement password hashing
- [ ] Build Swing login and registration interfaces
- [ ] Write unit tests

---

## 2. Image Search & Browsing — Kevin

**User Story:** As a user, I want to search and browse images so that I can discover inspiration for my projects.

### Search Functionality

**Example Workflow:**
1. User enters "Japanese interior design" into the search bar.
2. User clicks Search.
3. Application sends the query to the Unsplash API.
4. Unsplash returns matching image metadata.
5. Application displays images in a grid.

**Tasks:**
- [ ] Set up Unsplash API integration
- [ ] Create `UnsplashClient` for HTTP requests
- [ ] Implement keyword search
- [ ] Parse image metadata from JSON responses
- [ ] Create `SearchImage` / `ImageResult` model
- [ ] Build Swing search bar
- [ ] Display images in a grid
- [ ] Implement image loading
- [ ] Handle API errors, empty results, and rate limits
- [ ] Write unit tests

### Filter & Sort Functionality

**Potential filters:**
- Categories (drawings, photography, architecture, etc.)
- Sort by relevance
- Sort by newest
- Sort by popularity

**Tasks:**
- [ ] Add sorting dropdown
- [ ] Implement relevance and newest sorting using supported API options
- [ ] Investigate popularity sorting using available metadata
- [ ] Implement category filters
- [ ] Connect filter controls to search results
- [ ] Test sorting and filtering

**Note:** Unsplash primarily provides photographs. Drawing and illustration categories may require keyword searches or another API.

---

## 3. Personalized Recommendations — Kevin

**User Story:** As a user, I want personalized recommendations based on preferences for a board so that I can discover pictures that interest me.

### Recommendation Algorithm

Images are converted into numerical vectors representing their visual features. The application compares a board's preference vector with candidate image vectors using cosine similarity.

**Workflow:**

Board Pins → Image Vectors → Average Preference Vector → Candidate Images → Cosine Similarity → Ranked Recommendations

### Core Tasks

- [ ] Research image embedding approaches (CLIP, ONNX Runtime, DJL)
- [ ] Implement image feature vector extraction
- [ ] Calculate a board preference vector
- [ ] Implement cosine similarity
- [ ] Rank candidate images by similarity
- [ ] Generate recommendations separately for each board
- [ ] Display recommended images in Swing
- [ ] Handle boards without sufficient pins
- [ ] Write recommendation algorithm unit tests

### Optional Features

**Taste Mixer:**

Blend two users' or boards' preferences using a slider.

Example:

`targetVector = 0.7 * boardA + 0.3 * boardB`

- [ ] Implement weighted vector blending
- [ ] Add Swing slider to control weights
- [ ] Generate blended recommendations

**Group Recommendations:**
- [ ] Compare candidates against multiple preference vectors
- [ ] Rank images that perform well for multiple users

**Board Analyzer:**
- [ ] Calculate average board vector
- [ ] Identify pins that differ significantly from the board's theme

---

## 4. Pin Management — Alex

**User Story:** As a user, I want to create, view, and edit an individual pin's image, title, description, and tags.

### Pin Model

```java
public class Pin {
    private String id;
    private String title;
    private String imageUrl;
    private String description;
    private List<String> tags;
}
```

### Task A — Shared JSON Utility

- [ ] Implement reusable JSON reading utility
- [ ] Implement reusable JSON writing utility
- [ ] Handle missing files and invalid JSON
- [ ] Share utility with other repository implementations
- [ ] Test JSON persistence

### Task B — Pin Persistence

- [ ] Create `PinRepository` interface
- [ ] Implement JSON-based `PinRepository`
- [ ] Save a new Pin
- [ ] Find a Pin by ID
- [ ] Update Pin metadata
- [ ] Store Pin metadata in `pins.json`
- [ ] Verify persistence after application restart

### Task C — Pin Use Case

- [ ] Implement `CreatePin` or `EditPin`
- [ ] Validate Pin fields
- [ ] Connect use case to repository
- [ ] Build Swing interface
- [ ] Write unit tests

**Success Criteria:** A saved Pin remains available after closing and reopening the application.

---

## 5. Board Management — Gabriel

**User Story:** As a user, I want to create, view, and edit boards so that I can organize pictures.

**Use Case:** Manage Boards

### Main Workflow

1. User navigates to the Saved page.
2. Application displays the user's boards.
3. User selects Create, Rename, or Delete.
4. Application updates the selected board.
5. Changes persist in `boards.json`.

### Tasks

- [ ] Create `Board` entity
- [ ] Create `BoardRepository` interface
- [ ] Implement JSON board persistence
- [ ] Implement Create Board
- [ ] Implement View Boards
- [ ] Implement Rename Board
- [ ] Implement Delete Board
- [ ] Implement Add Pin to Board
- [ ] Implement Remove Pin from Board
- [ ] Associate boards with user IDs
- [ ] Build Swing Saved/Boards page
- [ ] Write unit tests

**Example Structure:**

```text
User
 └── Board: Japanese Architecture
       ├── Pin 1: Minimalist living room
       ├── Pin 2: Wooden house
       └── Pin 3: Traditional Japanese
```

---

## 6. User Profile Customization — Kieran & Matthew

**User Story:** As a user, I want to customize my profile so that I can express myself.

### Profile Properties

```java
public class UserProfile {
    private String userId;
    private String displayName;
    private String biography;
    private String avatarPath;
    private String bannerPath;
    private String featuredBoardId;
}
```

### Appearance Settings

```java
public class AppearanceSettings {
    private Theme theme;
    private String accentColor;
    private String fontFamily;
    private int fontSize;
    private boolean highContrast;
}
```

### Tasks

- [ ] Create `UserProfile` entity
- [ ] Create `AppearanceSettings` entity
- [ ] Implement profile editing
- [ ] Implement display name customization
- [ ] Implement biography editing
- [ ] Implement avatar and banner customization
- [ ] Implement light/dark mode
- [ ] Implement accent color customization
- [ ] Implement font and font size customization
- [ ] Implement high contrast setting
- [ ] Persist settings in `profiles.json`
- [ ] Build Swing profile customization interface
- [ ] Write unit tests

---

## JSON Data Ownership

| File | Owner | Data Stored |
|---|---|---|
| `users.json` | Matthew | User IDs, usernames, password hashes |
| `profiles.json` | Kieran | Bios, avatars, banners, appearance settings |
| `pins.json` | Alex | Pin IDs, URLs, titles, descriptions, metadata |
| `boards.json` | Gabriel | Board IDs, owner IDs, saved Pin IDs |
| `likes.json` | TBD | User–Pin likes for application-specific popularity |

**Important:** Each teammate owns their JSON schema. All team members should use the shared JSON utility where appropriate.

---

## Unsplash API Integration

**Documentation:** https://unsplash.com/documentation

### Example API Response

```json
{
  "id": "abc123",
  "created_at": "2026-09-15T12:30:00Z",
  "likes": 248,
  "description": "Japanese minimalist interior",
  "urls": {
    "regular": "https://images.unsplash.com/..."
  }
}
```

### Required Image Metadata

| Attribute | Purpose |
|---|---|
| `id` | Unique Unsplash photo identifier |
| `created_at` | Original upload date |
| `likes` | Unsplash like count, when available |
| `description` | Image description |
| `urls.regular` | Image display URL |
| `user` | Photographer attribution |

### API Tasks

- [ ] Verify exact response fields against Unsplash documentation
- [ ] Implement image metadata model
- [ ] Implement JSON response parsing
- [ ] Load images from returned URLs
- [ ] Follow Unsplash attribution and API usage requirements
- [ ] Ensure API access credentials are not committed to GitHub

---

## Shared Architecture

### Planned Layers

```text
Presentation Layer (Java Swing)
             |
             v
Use Case Layer
(Search, Recommendations, Pins, Boards, Profiles)
             |
             v
Interface / Repository Layer
             |
       +-----+------+
       |            |
       v            v
   Unsplash API   JSON Storage
                      |
          +-----------+------------+
          |           |            |
      users.json  boards.json  pins.json
      profiles.json          likes.json
```

### Architecture Tasks

- [ ] Agree on package structure
- [ ] Define entities and interfaces
- [ ] Define shared JSON schemas
- [ ] Connect use cases to repositories
- [ ] Connect Swing screens to use cases
- [ ] Create UML class diagram
- [ ] Review dependencies between team features
- [ ] Test cross-feature integration

---

## Project Milestones

### Milestone 1 — Planning & Architecture

- [ ] Finalize user stories
- [ ] Finalize use cases
- [ ] Assign responsibilities
- [ ] Define interfaces between components
- [ ] Create UML class diagram
- [ ] Agree on JSON structure

### Milestone 2 — Core Implementation

- [ ] Registration and login
- [ ] Unsplash image search
- [ ] Pin creation and persistence
- [ ] Board management
- [ ] Profile customization
- [ ] Basic Swing navigation

### Milestone 3 — Advanced Functionality

- [ ] Recommendation algorithm
- [ ] Board-specific recommendations
- [ ] Search filtering and sorting
- [ ] Optional Taste Mixer
- [ ] Optional group recommendations
- [ ] Optional Board Analyzer

### Milestone 4 — Testing & Integration

- [ ] Unit tests for each use case
- [ ] JSON persistence tests
- [ ] Unsplash API integration tests
- [ ] GUI interaction tests
- [ ] Cross-feature integration tests
- [ ] Resolve outstanding bugs
- [ ] Final code review

---

## GitHub Workflow

Each feature should be developed on a separate branch.

**Suggested Branch Names:**

```text
feature/authentication
feature/image-search
feature/recommendations
feature/pin-management
feature/board-management
feature/profile-customization
```

**Workflow:**
1. Create a feature branch.
2. Implement the assigned functionality.
3. Write and run tests.
4. Commit changes.
5. Push branch to GitHub.
6. Open a Pull Request.
7. Request review before merging into `main`.

**Pull Request Checklist:**
- [ ] Feature implements its user story
- [ ] Code compiles
- [ ] Unit tests pass
- [ ] No API secrets or passwords committed
- [ ] Shared interfaces remain compatible
- [ ] Changes reviewed by another teammate

---

## Outstanding Decisions

- [ ] Assign an owner to `likes.json`
- [ ] Decide on recommendation embedding model
- [ ] Confirm Unsplash API rate limits and image usage requirements
- [ ] Decide how image vector embeddings are cached
- [ ] Decide whether images are stored only as URLs
- [ ] Agree on how boards reference pins
- [ ] Determine how search filtering interacts with API results
- [ ] Establish integration/testing deadlines
- [ ] Finalize UML class diagram


