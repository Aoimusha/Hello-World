//  Score_management_system_project
//
//  Created by Joel Perez on 12/11/13.
//

#include "stdio.h"

#include "string.h"

/*Define Student struct*/

struct Student

{
    
    char ID[20];
    
    char Name[20];
    
    float Mark1;
    
    float Mark2;
    
    float Mark3;
    
    float Average;
    
};


/*Declare students Array and students Numbers*/

struct Student students[1000];

int num=0;


float Avg(struct Student stu);

int Student_SearchByIndex(char id[]);

int Student_SearchByName(char name[]);

void Student_DisplaySingle(int index);

void Student_Insert();

void Student_Modify();

void Student_Delete();

void Student_Select();

void Student_SortByAverage();

void Student_Display();

void IO_ReadInfo();

void IO_WriteInfo();


/*main*/

int main(void)//begin main function

{
    
    int selection;//initialize selection variable
    
    printf("Welcome to the Score Management Program!\n");//greeting message
    
    do {//program loop
        printf("\nWhat would you like to do?\n\n"//main menu
               "\t- Insert New Student Record      (Enter 1)\n"
               "\t- Modify Existing Student Record (Enter 2)\n"
               "\t- Delete Student from Record     (Enter 3)\n"
               "\t- Search Record by Name          (Enter 4)\n"
               "\t- Sort Record by Average         (Enter 5)\n"
               "\t- View Record                    (Enter 6)\n"
               "\t- End Program                    (Enter -1)\n\n");
        scanf("%d", &selection);//reads user input

        while (selection > 6 || selection < -1) {//loop condition
            printf("Error! Improper response entered! Try Again\n\n");
            scanf("%d", &selection);//user prompt
        }
    
        switch (selection) {//selects action based on selection
            
            case 1:
                Student_Insert();
                break;
            
            case 2:
                Student_Modify();
                break;
            
            case 3:
                Student_Delete();
                break;
            
            case 4:
                Student_Select();
                break;
                
            case 5:
                Student_SortByAverage();
                Student_Display();
                break;
            
            case 6:
                Student_Display();
                break;
                
            case -1:
                printf("\nGoodbye...\n\n");//goodbye message when program ended
                return 0;
                break;
            
        }
        
    } while ( selection != -1 );//condition for continuing loop
    
}//end main



/*Average score*/

float Avg(struct Student stu)

{
    
    return (stu.Mark1+stu.Mark2+stu.Mark3)/3;
    
}



/*Search by Student ID*/

int Student_SearchByIndex(char id[])

{
    
    int i;
    
    for (i=0;i<num;i++)
        
    {
        
        if (strcmp(students[i].ID,id)==0)
            
        {
            
            return i;
            
        }
        
    }
    
    return -1;
    
}



/*Search by Name*/

int Student_SearchByName(char name[])

{
    
    int i;
    
    for (i=0;i<num;i++)
        
    {
        
        if (strcmp(students[i].Name,name)==0)
            
        {
            
            return i;
            
        }
        
    }
    
    return -1;
    
}



/*diplay single*/

void Student_DisplaySingle(int index)

{
    
    printf("%10s%10s%8s%8s%8s%10s\n","ID","NAME","SCORE","SCORE","SCORE","AVERAGE");
    
    printf("-------------------------------------------------------------\n");
    
    printf("%10s%10s%8.2f%8.2f%8.2f%10.2f\n",students[index].ID,students[index].Name,
           
           students[index].Mark1,students[index].Mark2,students[index].Mark3,students[index].Average);
    
}



/*Insert student info*/

void Student_Insert()

{
    
    while(1)
        
    {
        
        printf("\nPlease enter the student ID:");
        
        scanf("%s",students[num].ID);
        
        getchar();
        
        
        
        printf("Please enter the student NAME:");
        
        scanf("%s",students[num].Name);
        
        getchar();
        
        
        
        printf("Please enter the student score:");
        
        scanf("%f",&students[num].Mark1);
        
        getchar();
        
        
        
        printf("Please enter the student score:");
        
        scanf("%f",&students[num].Mark2);
        
        getchar();
        
        
        
        printf("Please enter the student score:");
        
        scanf("%f",&students[num].Mark3);
        
        getchar();
        
        
        
        students[num].Average=Avg(students[num]);
        
        num++;
        
        
        
        printf("Do you want to proceed?(y/n)");
        
        if (getchar()=='n')
            
        {
            
            break;
            
        }
        
    }
    
    
    
}



/*Modify student info*/

void Student_Modify()

{
    
    //float mark1,mark2,mark3;
    
    while(1)
        
    {
        
        char id[20];
        
        int index;
        
        printf("\nPlease enter the student ID:");
        
        scanf("%s",id);
        
        getchar();
        
        index=Student_SearchByIndex(id);
        
        if (index==-1)
            
        {
            
            printf("Not exist!\n");
            
        }
        
        else
            
        {
            
            printf("The student info you want to modify is:\n");
            
            Student_DisplaySingle(index);
            
            printf("-- Please enter new value --\n");
            
            
            printf("Please enter the student ID:");
            
            scanf("%s",students[index].ID);
            
            getchar();
            
            
            printf("Please enter the student NAME:");
            
            scanf("%s",students[index].Name);
            
            getchar();
            
            
            printf("Please enter the student SCORE:");
            
            scanf("%f",&students[index].Mark1);
            
            getchar();
            
            
            printf("Please enter the student SCORE:");
            
            scanf("%f",&students[index].Mark2);
            
            getchar();
            
            
            printf("Please enter the student SCORE:");
            
            scanf("%f",&students[index].Mark3);
            
            getchar();
            
            
            students[index].Average=Avg(students[index]);
            
        }
        
        printf("Do you want to proceed?(y/n)");
        
        if (getchar()=='n')
            
        {
            
            break;
            
        }
        
    }
    
}



/*Delete student info*/

void Student_Delete()

{
    
    int i;
    
    while(1)
        
    {
        
        char id[20];
        
        int index;
        
        printf("\nPlease enter the student ID you want to delete:");
        
        scanf("%s",id);
        
        getchar();
        
        index=Student_SearchByIndex(id);
        
        if (index==-1)
            
        {
            
            printf("Not exist!\n");
            
        }
        
        else
            
        {
            
            printf("The student info to delete is:\n");
            
            Student_DisplaySingle(index);
            
            printf("Are you sure you want to delete this?(y/n)");
            
            if (getchar()=='y')
                
            {
                
                for (i=index;i<num-1;i++)
                    
                {
                    
                    students[i]=students[i+1];//move the following student forward
                    
                }
                
                num--;
                
            }
            
            getchar();
            
        }
        
        printf("Do you want to proceed?(y/n)");
        
        if (getchar()=='n')
            
        {
            
            break;
            
        }
        
    }
    
}



/*Search by name*/

void Student_Select()

{
    
    while(1)
        
    {
        
        char name[20];
        
        int index;
        
        printf("\nPlease enter the searched name:");
        
        scanf("%s",name);
        
        getchar();
        
        index=Student_SearchByName(name);
        
        if (index==-1)
            
        {
            
            printf("Not exist!\n");
            
        }
        
        else
            
        {
            
            printf("The searched students info:\n");
            
            Student_DisplaySingle(index);
            
        }
        
        printf("Do you want to proceed?(y/n)");
        
        if (getchar()=='n')
            
        {
            
            break;
            
        }
        
    }
    
}



/*Sort by average*/

void Student_SortByAverage()

{
    
    int i,j;
    
    struct Student tmp;
    
    for (i=0;i<num;i++)
        
    {
        
        for (j=1;j<num-i;j++)
            
        {
            
            if (students[j-1].Average<students[j].Average)
                
            {
                
                tmp=students[j-1];
                
                students[j-1]=students[j];
                
                students[j]=tmp;
                
            }
            
        }
        
    }
    
}



/*Display student info*/

void Student_Display()

{
    
    int i;
    
    printf("%10s%10s%8s%8s%8s%10s\n","ID","NAME","SCORE","SCORE","SCORE","AVERAGE");
    
    printf("-------------------------------------------------------------\n");
    
    for (i=0;i<num;i++)
        
    {
        
        printf("%10s%10s%8.2f%8.2f%8.2f%10.2f\n",students[i].ID,students[i].Name,
               
               students[i].Mark1,students[i].Mark2,students[i].Mark3,students[i].Average);
        
    }
    
}



/*Read student info from file*/

void IO_ReadInfo()

{
    
    FILE *fp;
    
    int i;
    
    if ((fp=fopen("Database.txt","rb"))==NULL)
        
    {
        
        printf("Could not open the file!\n");  
        
        return;  
        
    }  
    
    if (fread(&num,sizeof(int),1,fp)!=1)  
        
    {  
        
        num=-1;  
        
    }  
    
    else  
        
    {  
        
        for(i=0;i<num;i++)  
            
        {  
            
            fread(&students[i],sizeof(struct Student),1,fp);  
            
        }  
        
    }  
    
    fclose(fp);  
    
}  



/*Write student info to file*/  

void IO_WriteInfo()  

{  
    
    FILE *fp;  
    
    int i;  
    
    if ((fp=fopen("Database.txt","wb"))==NULL)  
        
    {  
        
        printf("Could not open file!\n");  
        
        return;  
        
    }  
    
    if (fwrite(&num,sizeof(int),1,fp)!=1)  
        
    {  
        
        printf("Error writing to file!\n");  
        
    }  
    
    for (i=0;i<num;i++)  
        
    {  
        
        if (fwrite(&students[i],sizeof(struct Student),1,fp)!=1)  
            
        {  
            
            printf("Error writing to file!\n");  
            
        }  
        
    }      
    
    fclose(fp);  
    
}  

