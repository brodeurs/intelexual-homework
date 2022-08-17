package com.project.assignment.dto

import com.project.assignment.entity.File
import com.project.assignment.entity.Project
import com.project.assignment.entity.User
import spock.lang.Specification

import java.sql.Date

class ProjectDtoTest extends Specification {

    def "Test Project Dto hydration from overloaded constructor"() {
        given: 'Assign user mocks'
        User userMock1 = Mock(User)
        User userMock2 = Mock(User)
        File fileMock1 = Mock(File)
        File fileMock2 = Mock(File)

        ProjectDto projectDto


        when: "Conversion of User entity to dto requires accessors return data"

        1 * userMock1.getName() >> "Bilbo Baggins"
        1 * userMock1.getEmailAddress() >> "bb@shire.com"
        1 * userMock2.getName() >> "Gandalf Grey"
        1 * userMock2.getEmailAddress() >> "gg@wizards.com"
        1 * userMock1.getProjects() >> new HashSet<>()
        1 * userMock2.getProjects() >> new HashSet<>()

        Set<User> users = new HashSet<>()
        users << userMock1
        users << userMock2

        1 * fileMock1.getName() >> "File 1"
        1 * fileMock1.getFileType() >> "Text"
        1 * fileMock2.getName() >> "File 2"
        1 * fileMock2.getFileType() >> "PDF"

        Set<File> files = new HashSet<>()
        files << fileMock1
        files << fileMock2

        Project project = new Project("Project entity 1", new Date(1L))
        project.setFiles(files)
        project.setUsers(users)

        projectDto = new ProjectDto(project)

        then:
        projectDto
        projectDto.getName() == "Project entity 1"
        projectDto.getStartDate().time == 1
        projectDto.getUsers().size() == 2
        projectDto.getFiles().size() == 2


    }

}
