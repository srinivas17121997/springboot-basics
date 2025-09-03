# Company Data Minimisation - Account Deletion Readiness

## 📌 Problem Statement
As part of data minimisation efforts and GDPR compliance, Company needs a system to **identify user accounts that are ready for deletion**.  

A user account is considered ready for deletion based on these rules:

1. **Inactivity Rule**:  
   - If a user has not performed any valid activity within a specified inactivity period (e.g., 90 days), their account should be flagged for deletion.  
   - Certain activities (like *marketing email interactions*) are ignored when deciding the last valid interaction.

2. **User-Initiated Deletion Request**:  
   - If the user has explicitly requested deletion (via an external flag on the account), the account is ready for deletion.  
   - This flag is assumed to be managed outside the scope of this exercise.

> ⚠️ More rules may be added in the future.

---

## 📥 Input

1. **Users**  
   - A list of users, each represented by a unique identifier.

2. **Activities**  
   - Each activity corresponds to an interaction performed by a user.  
   - Examples: website login, mobile app login, store purchase, marketing email interaction.  
   - Each activity includes:  
     - **Activity Type**  
     - **Timestamp** (ISO 8601 format)  
     - **User ID**

3. **Current Time**  
   - A fixed timestamp representing the current evaluation time.

---

## 📤 Output
- A list of user IDs whose accounts are **ready for deletion**.

---

## ⚙️ Constraints
- Input lists can contain up to **10^9 elements** (very large datasets).  
- Timestamps are provided in **ISO 8601 format**.  
- The solution must handle **big data scale efficiently** (streaming or distributed approaches may be required).  

---

## 📝 Example

### Input:
**Users**
- User 1  
- User 2  
- User 3  

**Activities**

| Activity                  | Time                     | User   |
|----------------------------|--------------------------|--------|
| market email interaction   | 2020-07-10 15:00:00.000 | User 2 |
| market email interaction   | 2024-04-20 15:00:00.000 | User 3 |
| website login              | 2024-03-10 15:00:00.000 | User 1 |
| website login              | 2024-04-10 15:00:00.000 | User 2 |
| mobile app login           | 2020-07-10 15:00:00.000 | User 3 |

**Current Time**  
`2024-05-01 11:00:00.000`

---

### Output:
