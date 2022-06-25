typedef struct TMan_task {
    int period;
    int phase;
    int deadline;
    int current_a;
    int deadline_count;
    int next_a;
    int wcet;
    int priority;
    
    //precedence constrains (?))
    const char* name;
}TMan_task;


/*initialisation of the framework*/
void TMAN_Init (int);

/*terminate the framework*/
void TMAN_Close (void);

/*Add a task to the framework*/
void TMAN_TaskAdd (const char*, int);

/*Register attributes (e.g. period, phase, deadline, precedence
constraints) for a task already added to the framework*/
void TMAN_TaskRegisterAttributes (const char*, int, int, int, int, int, int);

/*Called by a task to signal the termination of an instance and wait for
the next activation*/
void TMAN_TaskWaitPeriod (void);

/* Verify the Feasibility of the systems, processing the data from all tasks */
int TMAN_Feasibility (void);

/* Calculates the Worst Case Scenario Times from all tasks, regarding the 
 existence of higher priority ones, until convergence or deadline miss*/
int TMAN_Wcet(TMan_task task);

/*returns statistical information about a task. Provided information must
include at least the number of activations, but additional info (e.g. number of deadline misses)
will be valued. */
void TMAN_TaskStats (void);

void TMAN_getTicks (void *pvParams);

void printTask(void *pvParam);

void BusyWait (void *pvParams);