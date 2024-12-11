## Page Replacement Algorithms 

Page Replacement Algorithms are used in operating systems for managing the memory efficiently. These algorithms are strategies that are applied in operating systems to determine which page needs to be replaced by the new page that a process wants to use at that point of time.

There are few things that need to be understood about these algorithms.

1. *Page* - A page is a fixed block of memory that contains certain data. It is stored in a virtual disk. Pages that are not in use are stored in disk and replaced with the pages from the physical memory when needed by the process.
2. *Process* - A process is a program under execution. Wheneevr process needs some data for execution, it asks the physical memory for that data stored in the form of pages. 
3. *Virtual Memory* - A virtual memory is the type of memory that is used from a hard drive to store pages. The purpose of virtual memory is to make sure that processes do not completely rely on physical memory for pages.
4. *Physical Memory* - Physical memory, also knows as Main memory, is the memory space where processes look for the data. If the physical memory doesn't have the requested page, it sends a request to virtual memory and gets that page. Upon getting that page, various page replacement algorithms are used to determine which page needs to be replaced in the main memory with the requested page.
5. *Page Fault* - A page fault is an error that occurs when a requested page is not found in main memory. In this case, the operating system is responsible for getting that page from a virtual memory.

##

### Different types of Page Replacement Algorithms:

There are 5 types of algorithms that we will cover in this section. They are,

1. *FIFO* - **First-in-First-out** is a simple technique where pages in the queue are replaced in the order of loading. In other terms, oldest page in the memory gets replaced.
2. *LIFO* - **Last-in-First-out** is the opposite of FIFO where newest page in the memory gets replaced.
3. *LRU* - **Least Recently Used** is an algorithm in which a page that has been used least number of times is replaced.
4. *MRU* - **Most Recently Used** is quite opposite to LRU where a page that is used most number of times is replaced.
5. *Optimal Page Replacement* - Optimal Page Replacement is a page replacement technique that replaces the page which will not be used for long periods of time in the future. This is the most efficient algorithm that comparatively yields less page faults.

##
