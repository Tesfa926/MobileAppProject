package com.example.courselist.ui.model

// This file contains the Course data class and a reusable list of courses for the app.

data class Course(
    val courseCode: String,
    val courseTitle: String,
    val ectsPerWeek: Int,
    val description: String,
    val prerequisite: String
)

val courseList = listOf(
    Course(
        courseCode = "SECT-2121",
        courseTitle = "Fundamentals of Electrical Circuits and Electronics",
        ectsPerWeek = 5,
        description = "Introduces basic concepts of electricity, circuit components, and their behavior in analog and digital systems.",
        prerequisite = "None"
    ),
    Course(
        courseCode = "SECT-2111",
        courseTitle = "Fundamentals of Software Engineering",
        ectsPerWeek = 5,
        description = "Covers the software development lifecycle, requirements analysis, design principles, and documentation practices.",
        prerequisite = "Fundamentals of Database"
    ),
    Course(
        courseCode = "SECT-3122",
        courseTitle = "Computer Organizations and Architecture",
        ectsPerWeek = 7,
        description = "Explores the structure and function of computer systems, including CPU, memory, I/O, and instruction execution.",
        prerequisite = "None"
    ),
    Course(
        courseCode = "SECT-3131",
        courseTitle = "Human Computer Interaction",
        ectsPerWeek = 5,
        description = "Focuses on designing user-friendly systems by understanding user needs, usability principles, and interface evaluation.",
        prerequisite = "None"
    ),
    Course(
        courseCode = "SECT-3112",
        courseTitle = "Web Design and Programming",
        ectsPerWeek = 7,
        description = "Teaches front-end and back-end web development using HTML, CSS, and scripting languages, with emphasis on user experience.",
        prerequisite = "Object-Oriented Programming"
    ),
    // New courses for the next semester
    Course(
        courseCode = "SECT-3151",
        courseTitle = "Fundamentals of AI",
        ectsPerWeek = 5,
        description = "Introduces core AI concepts like intelligent agents, search algorithms, and basic machine learning.",
        prerequisite = "Data Structures and Algorithms"
    ),
    Course(
        courseCode = "SECT-3141",
        courseTitle = "Fundamentals of Cybersecurity",
        ectsPerWeek = 5,
        description = "Covers essential topics in digital security, including threats, encryption, and secure systems.",
        prerequisite = "Fundamentals of Networking"
    ),
    Course(
        courseCode = "SECT-3132",
        courseTitle = "Computer Graphics",
        ectsPerWeek = 5,
        description = "Explores 2D/3D rendering, transformations, and image processing techniques using graphics APIs.",
        prerequisite = "Human Computer Interaction"
    ),
    Course(
        courseCode = "SECT-3113",
        courseTitle = "Mobile Application Development",
        ectsPerWeek = 7,
        description = "Focuses on building native and cross-platform mobile apps with practical UI/UX and backend integration.",
        prerequisite = "None"
    ),
    Course(
        courseCode = "SECT-3082",
        courseTitle = "Operating Systems and System Programming",
        ectsPerWeek = 7,
        description = "Teaches OS concepts like processes, memory management, file systems, and low-level programming.",
        prerequisite = "Computer Organization and Architecture"
    )
)

val semesterQuote = "You don't have to be brilliant, just consistent.\n— Kelsey Hightower, Google Cloud engineer and respected open-source contributor" 