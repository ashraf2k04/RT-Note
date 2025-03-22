package com.example.rtnotes

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)


fun generateSampleNotes(): List<Note> {
    return listOf(
        Note(
            id = 1,
            title = "Grocery List",
            content = "Milk, Eggs, Bread, Cheese",
            timestamp = System.currentTimeMillis() - 86400000 // Yesterday
        ),
        Note(
            id = 2,
            title = "Meeting Notes",
            content = "Discuss project timeline, assign tasks, schedule follow-up",
            timestamp = System.currentTimeMillis() - 172800000 // Two days ago
        ),
        Note(
            id = 3,
            title = "Ideas for Vacation",
            content = "Beach, Hiking, Sightseeing, Relaxing",
            timestamp = System.currentTimeMillis() - 604800000 // Last week
        ),
        Note(
            id = 4,
            title = "Book Recommendations",
            content = "The Lord of the Rings, Pride and Prejudice, 1984",
            timestamp = System.currentTimeMillis() - 2592000000 // Last month
        ),
        Note(
            id = 5,
            title = "Workout Plan",
            content = "Monday: Chest, Tuesday: Back, Wednesday: Legs, Thursday: Shoulders, Friday: Arms",
            timestamp = System.currentTimeMillis()
        )
    )
}